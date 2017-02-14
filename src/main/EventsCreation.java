package main;

import java.util.ArrayList;
import java.util.Collection;

import characters.Enemy;
import characters.Goblin;
import characters.Player;
import main.BattleEvent;
import main.BlankChoice;
import main.BlankEvent;
import main.Book;
import main.Choice;
import main.Event;

public class EventsCreation 
{
	public Event[] allEvents;
	
	public EventsCreation(Player[] players)
	{
		this.allEvents = new Event[3];
		this.createAllEvents(players);
	}
	
	public void createAllEvents(Player[] players){
		createStartEvent();
		createEventTwo();
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
        Choice choiceOne = new BlankChoice("Sair do quarto", 1);
        Choice choiceTwo = new BlankChoice("Ir ao evento dois", 1);
        Choice choiceThree = new BlankChoice("Bater a cabeça na parede", 0);
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
	
	private void createEventBattle(Player[] players)
	{
		Enemy[] enemies =  new Enemy[]{ new Goblin(0) };
		
		Collection choices = new ArrayList<Choice>();
		for(int i = 0; i < players.length; i++){
			Player player = players[i];
			for(int j = 0; j < player.getSkillsNames().length; j++){
				choices.add(new BlankChoice(player.getSkillsNames()[j], j));
			}
		}
		
		for(int i = 0; i < enemies.length; i++){
			choices.add(new BlankChoice("Continuar", 0));
		}
        
        this.allEvents[2] = new BattleEvent("aa", choices, players,  enemies);
	}
}
