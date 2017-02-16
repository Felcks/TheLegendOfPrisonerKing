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
		this.allEvents = new Event[4];
		this.createAllEvents(players);
	}
	
	public void createAllEvents(Player[] players){
		createStartEvent();
		createEventTwo();
		createEventBattle(players);
		this.createEventThree();
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
        Choice choiceOne = new BlankChoice("Sair do quarto", 1);
        Choice choiceTwo = new BlankChoice("Ir ao evento dois", 1);
        Choice choiceThree = new BlankChoice("procurar por itens", 3);
        Choice choiceFour = new BlankChoice("Batalhar com um goblin randômico", 2);
        
        choices.add(choiceOne);
        choices.add(choiceTwo);
        choices.add(choiceThree);
        choices.add(choiceFour);
        
        this.allEvents[0] = new BlankEvent("Você está em um quarto escuro. O que quer fazer?", choices);
	}
	
	private void createEventTwo()
	{
		Collection choices = new ArrayList<Choice>();
        Choice choiceOne = new BlankChoice("Voltar ao start event", 0);
        Choice choiceTwo = new BlankChoice("tentar iniciar esse de novo", 0);
        
        choices.add(choiceOne);
        choices.add(choiceTwo);
        
        this.allEvents[1] = new BlankEvent("Event dois. O que quer fazer?", choices);
	}
	
	private void createEventThree()
	{
		Collection choices = new ArrayList<Choice>();
        Choice choiceOne = new ItemChoice("Pegar "+ ItemType.KEY.getName(), 0, ItemType.KEY);
        Choice choiceTwo = new BlankChoice("Voltar a atenção pro quarto", 0);
        
        choices.add(choiceTwo);
        choices.add(choiceOne);
        
        this.allEvents[3] = new ItemEvent("Procurar por itens", choices);
	}
	private void createEventBattle(Player[] players)
	{
		Enemy[] enemies =  new Enemy[]{ new Goblin(0, "Goblin_1"), new Goblin(0, "Goblin_2") };
		
		Collection choices = new ArrayList<Choice>();
		/*for(int i = 0; i < players.length; i++){
			Player player = players[i];
			String[] skillNames = player.getSkillsNamesForButtons();
			for(int j = 0; j < player.getSkillsNames().length; j++){
				choices.add(new BlankChoice(skillNames[j], j));
			}
		}
		
		for(int i = 0; i < enemies.length; i++){
			choices.add(new BlankChoice("Continuar", 0));
			choices.add(new BlankChoice("Continuar", 0));
			choices.add(new BlankChoice("Continuar", 0));
		}*/
        
        this.allEvents[2] = new BattleEvent("", choices, players,  enemies, 25);
	}
}
