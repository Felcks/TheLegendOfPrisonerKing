package main;

import java.util.ArrayList;
import java.util.Collection;

import characters.Enemy;
import characters.Goblin;
import characters.Player;
import itens.*;
import main.BattleEvent;
import main.BlankChoice;
import main.BlankEvent;
import main.Choice;
import main.Event;

public class EventsCreation 
{
	public Event[] allEvents;
	
	public EventsCreation(Player[] players)
	{
		this.allEvents = new Event[11];
		this.createAllEvents(players);
	}
	
	public void createAllEvents(Player[] players){
		createStartEvent();
		createEventCabecaNaParede();
		createEventCantarolar();
		createEventTatear();
		createEventTatear2();
		createEventSaidaDaCela();
		createEventDizerQueTudoFicaraBem();
		createEventPlanoRuim();
		createEventChamarGuarda();
		createEventSeduzirGuarda();
		createEventBattle(players);
	}
	
	public Event[] getAllEvents(){
		return this.allEvents;
	}
	
	public Event getStartEvent(){
		return this.getAllEvents()[0];
	}
	
	private void createStartEvent()
	{        
		Collection choices = new ArrayList<Choice>();
        Choice choiceOne = new BlankChoice("Cantarolar", 1);
        Choice choiceTwo = new BlankChoice("Bater a cabeça na parede", 2);
        Choice choiceThree = new BlankChoice("Tatear à procura da saída", 3);
        Choice choiceFour = new BlankChoice("Dizer que tudo ficará bem a seus companheiros", 4);
        
        choices.add(choiceOne);
        choices.add(choiceTwo);
        choices.add(choiceThree);
        choices.add(choiceFour);
        
        this.allEvents[0] = new BlankEvent("Você está em uma cela escura. O que fazer?", choices);
	}
	
	private void createEventCantarolar(){
		Collection choices = new ArrayList<Choice>();
        Choice choiceOne = new BlankChoice("Tentar fazer algo sério", 0);
        
        choices.add(choiceOne);
        
        this.allEvents[1] = new BlankEvent("1,2,3 indiozinhos. 4,5,6 indiozinhos. 7,8,9 indiozinhos....\n"
        		+ "Você cantarola muito bem. Seus companheiros aplaudem. \n"
        		+ "Mesmo assim, é melhor parar com a palhaçada.", choices);
	}
	
	private void createEventCabecaNaParede()
	{
		Collection choices = new ArrayList<Choice>();
        Choice choiceOne = new BlankChoice("Agir como um rei", 0);
        
        choices.add(choiceOne);
        
        this.allEvents[2] = new BlankEvent("Você é um rei! Aja como um!", choices);
	}
	
	private void createEventTatear(){
		Collection choices = new ArrayList<Choice>();
        Choice choiceOne = new BlankChoice("Continuar a tatear", 5 );
        Choice choiceTwo = new BlankChoice("Parar de tatear", 0);
        
        choices.add(choiceOne);
        choices.add(choiceTwo);
        
        this.allEvents[3] = new BlankEvent("Você começa a tatear a parede", choices);
	}
	
	
	private void createEventTatear2(){
		Collection choices = new ArrayList<Choice>();
        Choice choiceOne = new BlankChoice("Continuar a tatear", 6 );
        Choice choiceTwo = new BlankChoice("Parar de tatear", 0);
        
        choices.add(choiceOne);
        choices.add(choiceTwo);
        
        this.allEvents[5] = new BlankEvent("Seus parceiros seguem seu exemplo. Agora todos estão tateando a parede iguais uns malucos.", choices);
	}
	
	private void createEventSaidaDaCela(){
		Collection choices = new ArrayList<Choice>();	
        Choice choiceOne = new BlankChoice("Chamar o guardinha", 7);
        Choice choiceTwo = new BlankChoice("Pensar", 6);
        
        choices.add(choiceOne);
        choices.add(choiceTwo);
        
        this.allEvents[6] = new BlankEvent("Freya achou a saída da cela e todos foram a seu encontro. Tem um guarda de vigia. O que fazer?", choices);
	}
	
	private void createEventChamarGuarda(){
		Collection choices = new ArrayList<Choice>();	
        Choice choiceOne = new BlankChoice("Meu: Me liberte em nome de Sassenfeld!", 8);
        Choice choiceTwo = new BlankChoice("Freya: Hey, psiu, lindão.", 9);
        Choice choiceThree = new BlankChoice("Vivi quer fingir estar conjurando uma magia poderosa....", 8);
        Choice choiceFour = new BlankChoice("Zidane prefere xingar a mãe do guarda.", 8);
        
        choices.add(choiceOne);
        choices.add(choiceTwo);
        choices.add(choiceThree);
        choices.add(choiceFour);
        
        this.allEvents[7] = new BlankEvent("Todos deram palpites para chamar. Qual você quer seguir?", choices);
	}
	
	private void createEventPlanoRuim(){
		Collection choices = new ArrayList<Choice>();	
        Choice choiceOne = new BlankChoice("Tentar outra coisa...", 7);
        
        choices.add(choiceOne);
        
        this.allEvents[8] = new BlankEvent("Esse plano foi horrivel", choices);
	
	}
	
	private void createEventSeduzirGuarda(){
		Collection choices = new ArrayList<Choice>();	
        Choice choiceOne = new BlankChoice("Duelar com o guarda", 10);
        
        choices.add(choiceOne);
        

        this.allEvents[9] = new BlankEvent("O guarda está sendo seduzido. \n"
        		+ "Vocês se escondem. \n"
        		+ "O guarda entra na cela pra tentar alguma gracinha" , choices);
	}
	
	private void createEventDizerQueTudoFicaraBem()
	{
		/*Collection choices = new ArrayList<Choice>();
        Choice choiceOne = new ItemChoice("Pegar "+ ItemType.KEY.getName(), 0, ItemType.KEY);
        Choice choiceTwo = new BlankChoice("Voltar a atenção pro quarto", 0);
        
        choices.add(choiceTwo);
        choices.add(choiceOne);
        
        this.allEvents[3] = new ItemEvent("Procurar por itens", choices);*/
		
		Collection choices = new ArrayList<Choice>();
        Choice choiceOne = new BlankChoice("...", 0);
        
        choices.add(choiceOne);
        
        this.allEvents[4] = new BlankEvent("Steiner: Clã, tudo ficará bem. \n"
        		+ "Legal esse momento romantico, mas ninguém liga.", choices);
	
		
	}
	private void createEventBattle(Player[] players)
	{
		Enemy[] enemies =  new Enemy[]{ new Goblin(0, "Goblin_Guarda1"), new Goblin(0, "Goblin_Guarda2") };
		
		Collection choices = new ArrayList<Choice>();
        this.allEvents[10] = new BattleEvent("O guarda é um goblin. Veio outro goblin para ajuda-lo! ", choices, players,  enemies, 25);
	}
}
