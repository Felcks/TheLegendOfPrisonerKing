package main;

import java.util.ArrayList;
import java.util.Collection;

import characters.Enemy;
import characters.Goblin;
import characters.Mimico;
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
		this.allEvents = new Event[50];
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
		createEventIntro();
		createEventIntro2();
		createEventIntro3();
		createEventIntro4();
		createEventRevistarGuarda();
		createEventRevistandoOGuarda();
		createEventPonto14();
		createEventSeguir1();
		createEventSeguirEsquerda1();
		createEventSeguirEmFrente1();
		createEventMimico();
		createEventBattleMimico(players);
		createEndBattleMimico();
		
	}
	
	public Event[] getAllEvents(){
		return this.allEvents;
	}
	
	public Event getStartEvent(){
		return this.getAllEvents()[0];
	}
	
	private void createEventIntro(){
		Collection choices = new ArrayList<Choice>();
		choices.add(new BlankChoice("Continuar", 1));
       
        
        this.allEvents[0] = new BlankEvent("No dia do aniversário de sua filha,"
        		+ "o rei Steiner do \nreino Sassenfeld realizou um grande banquete.\nConvidando a todos.", choices);
	}
	
	private void createEventIntro2(){
		Collection choices = new ArrayList<Choice>();
		choices.add(new BlankChoice("Continuar", 2));
       
        
        this.allEvents[1] = new BlankEvent("Porém, ele não esperava a presença de traidores,"
        		+ "loucospara tomar seu trono.\nKefka seu arquirrival, desde criança, armou uma \nrebelião."
        		+ " Esperou todos os guardas e o rei ficarem \nbêbados para ter alguma chance de seu plano dar certo.", choices);
	}
	
	private void createEventIntro3(){
		Collection choices = new ArrayList<Choice>();
		choices.add(new BlankChoice("Continuar", 3));
       
        
        this.allEvents[2] = new BlankEvent("Kefka então, sequestrou o rei e os três cavaleiros de Sassenfeld.\n"
        		+ "Prendendo-os na masmorra da cidade.", choices);
	}
	
	private void createEventIntro4(){
		Collection choices = new ArrayList<Choice>();
		choices.add(new BlankChoice("Iniciar a jornada!", 4));
       
        
        this.allEvents[3] = new BlankEvent("Você é o rei Steiner. Sua missão é sair da masmorra e tomar seu trono de volta.", choices);
	}
	
	private void createStartEvent()
	{        
		Collection choices = new ArrayList<Choice>();
        Choice choiceOne = new BlankChoice("Cantarolar", 5);
        Choice choiceTwo = new BlankChoice("Bater a cabeça na parede", 6);
        Choice choiceThree = new BlankChoice("Tatear à procura da saída", 7);
        Choice choiceFour = new BlankChoice("Dizer que tudo ficará bem a seus companheiros", 12);
        
        choices.add(choiceOne);
        choices.add(choiceTwo);
        choices.add(choiceThree);
        choices.add(choiceFour);
        
        this.allEvents[4] = new BlankEvent("Curado da ressaca, você acorda e percebe que está trancado em uma cela escura.", choices);
	}
	
	private void createEventCantarolar(){
		Collection choices = new ArrayList<Choice>();
        Choice choiceOne = new BlankChoice("Tentar fazer algo sério", 4);
        
        choices.add(choiceOne);
        
        this.allEvents[5] = new BlankEvent("1,2,3 indiozinhos. 4,5,6 indiozinhos. 7,8,9 indiozinhos....\n"
        		+ "Você cantarola muito bem. Seus companheiros aplaudem. \n"
        		+ "Mesmo assim, é melhor parar com a palhaçada.", choices);
	}
	
	private void createEventCabecaNaParede()
	{
		Collection choices = new ArrayList<Choice>();
        Choice choiceOne = new BlankChoice("Agir como um rei", 4);
        
        choices.add(choiceOne);
        
        this.allEvents[6] = new BlankEvent("Você é um rei! Aja como um!", choices);
	}
	
	private void createEventTatear(){
		Collection choices = new ArrayList<Choice>();
        Choice choiceOne = new BlankChoice("Continuar a tatear",  8);
        Choice choiceTwo = new BlankChoice("Parar de tatear", 4);
        
        choices.add(choiceOne);
        choices.add(choiceTwo);
        
        this.allEvents[7] = new BlankEvent("Você começa a tatear a parede", choices);
	}
	
	
	private void createEventTatear2(){
		Collection choices = new ArrayList<Choice>();
        Choice choiceOne = new BlankChoice("Continuar a tatear", 9 );
        Choice choiceTwo = new BlankChoice("Parar de tatear", 4);
        
        choices.add(choiceOne);
        choices.add(choiceTwo);
        
        this.allEvents[8] = new BlankEvent("Seus parceiros seguem seu exemplo. Agora todos estão tateando a parede iguais uns malucos.", choices);
	}
	
	private void createEventSaidaDaCela(){
		Collection choices = new ArrayList<Choice>();	
        Choice choiceOne = new BlankChoice("Chamar o guarda pau", 10);
        
        choices.add(choiceOne);
        
        this.allEvents[9] = new BlankEvent("Freya achou a saída da cela e todos foram a seu encontro. Tem um guarda de vigia. O que fazer?", choices);
	}
	
	private void createEventChamarGuarda(){
		Collection choices = new ArrayList<Choice>();	
        Choice choiceOne = new BlankChoice("Meu: Me liberte em nome de Sassenfeld!", 11);
        Choice choiceTwo = new BlankChoice("Freya: Hey, psiu, lindão.", 13);
        Choice choiceThree = new BlankChoice("Vivi quer fingir estar conjurando uma magia poderosa....", 11);
        Choice choiceFour = new BlankChoice("Zidane quer chamar o guarda de guarda pau.", 11);
        
        choices.add(choiceOne);
        choices.add(choiceTwo);
        choices.add(choiceThree);
        choices.add(choiceFour);
        
        this.allEvents[10] = new BlankEvent("Todos deram palpites para chamar. Qual você quer seguir?", choices);
	}
	
	private void createEventPlanoRuim(){
		Collection choices = new ArrayList<Choice>();	
        Choice choiceOne = new BlankChoice("Tentar outra coisa...", 10);
        
        choices.add(choiceOne);
        
        this.allEvents[11] = new BlankEvent("Esse plano foi horrivel", choices);
	
	}
	
	private void createEventSeduzirGuarda(){
		Collection choices = new ArrayList<Choice>();	
        Choice choiceOne = new BlankChoice("Duelar com o guarda", 14);
        
        choices.add(choiceOne);
        

        this.allEvents[13] = new BlankEvent("O guarda está sendo seduzido. \n"
        		+ "Vocês se escondem. \n"
        		+ "O guarda entra na cela pra tentar alguma gracinha" , choices);
	}
	
	private void createEventDizerQueTudoFicaraBem()
	{	
		Collection choices = new ArrayList<Choice>();
        Choice choiceOne = new BlankChoice("...", 4);
        
        choices.add(choiceOne);
        
        this.allEvents[12] = new BlankEvent("Steiner:\"Clã, tudo ficará bem.\" \n"
        		+ "Legal esse momento romantico, mas ninguém liga.", choices);
	
		
	}
	private void createEventBattle(Player[] players)
	{
		Enemy[] enemies =  new Enemy[]{ new Goblin(0, "Goblin_Guarda1"), new Goblin(0, "Goblin_Guarda2") };
		
		Collection choices = new ArrayList<Choice>();
        this.allEvents[14] = new BattleEvent("O guarda é um goblin. Veio outro goblin para ajuda-lo! ", choices, players,  enemies, 25, 15);
	}
	
	private void createEventRevistarGuarda(){
		Collection choices = new ArrayList<Choice>();
		choices.add(new BlankChoice("Revistar o guarda pau!", 16));
		 this.allEvents[15] = new BlankEvent("Após a vitória, zidane propôe revistar o guarda pau.", choices);
	}
	
	private void createEventRevistandoOGuarda(){
		Collection choices = new ArrayList<Choice>();
		choices.add(new BlankChoice("...", 16));
		choices.add(new ItemChoice("Pegar mapa", 17, ItemType.MAP));
		 this.allEvents[16] = new ItemEvent("Vocês acharam um mapa..", choices, 14);
	}
	
	private void createEventPonto14(){
		Collection choices = new ArrayList<Choice>();
		choices.add(new BlankChoice("Estudar o mapa com seus cavalheiros", 18));
		 this.allEvents[17] = new BlankEvent("Vocês acharam um mapa!", choices, 14);
	}
	
	private void createEventSeguir1(){
		Collection choices = new ArrayList<Choice>();
		choices.add(new BlankChoice("Ir em frente.", 20));
		choices.add(new BlankChoice("Virar a esquerda.",19));
		 this.allEvents[18] = new BlankEvent("Vocês entram em um entendimento e percebem que existem dois caminhos, como rei cabe a você decidir.", choices, 14);
	}
	
	private void createEventSeguirEsquerda1(){
		Collection choices = new ArrayList<Choice>();
		choices.add(new BlankChoice("Continuar em busca da luz.", 0));
		choices.add(new BlankChoice("perguntar aos seus companheiros",0));
		 this.allEvents[19] = new BlankEvent("O ambiente está mais claro, talvez vocês estejam perto da porta", choices, 7);
	}
	
	private void createEventSeguirEmFrente1(){
		Collection choices = new ArrayList<Choice>();
		choices.add(new BlankChoice("Observar a linda sala", 21));
		//choices.add(new BlankChoice("Virar a esquerda.",0));
		 this.allEvents[20] = new BlankEvent("Vocês chegam em uma linda sala, com pisos de porcelana e janelas de seda. Nem parece que está no mesmo lugar de um quarto atrás...", choices, 9);
	}
	private void createEventMimico(){
		Collection choices = new ArrayList<Choice>();
		choices.add(new BlankChoice("Tentar impedi-lo!! pode ser uma armadilha!!!!", 22));
		choices.add(new BlankChoice("Assistir",22));
		 this.allEvents[21] = new BlankEvent("Ao olhar pro lado você percebe que o Zidane está tentando abrir um baú....", choices, 9);
	}
	
	private void createEventBattleMimico(Player[] players)
	{
		Enemy[] enemies = new Enemy[1];
		enemies[0] = new Mimico(0, "Mimico do bau de carvalho");
		
		Collection choices = new ArrayList<Choice>();
        this.allEvents[22] = new BattleEvent("O baú era um mimico.... Agora voces terão que enfrenta-lo", choices, players,  enemies, 25, 23);
	}
	
	private void createEndBattleMimico(){
		Collection choices = new ArrayList<Choice>();
		choices.add(new BlankChoice("Fazer discurso.", 0));
		choices.add(new BlankChoice("Revistar micico",0));
		 this.allEvents[23] = new BlankEvent("Foi uma grande batalha, todos estão orgulhosos de sua liderança. Agora estão cada vez"
		 		+ "mais corajosos para retomar o trono por voce", choices, 9);
	}
	
}
