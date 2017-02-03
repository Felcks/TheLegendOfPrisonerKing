package main;

import java.util.ArrayList;
import java.util.Collection;

import characters.Character;

public abstract class Event
{
    private String description;
    protected Collection<Choice> choices;
    private GameStatus eventStatus;
    
    public Event(String description, Collection<Choice> choices, GameStatus eventStatus) 
    {
        this.description = description;
        this.choices = new ArrayList<>();
        this.eventStatus = eventStatus;

        int i = 0;
        for(Choice choice:choices) {
            choice.defineNumber(i);
            this.choices.add(choice);
            i++;
        }
    }

    public String history() {
        return this.description;
    }

    public boolean isEndEvent() {
        if(this.choices.isEmpty()) 
        	return true;

        return false;
    }

    public Collection<Choice> nextEvents() {
        return this.choices;
    }

    public Choice findChoice(int number) 
    {
        for(Choice choice: this.choices) {
            if(choice.getNumber() == number) 
            	return choice;
        }

        return null;
    }
    
    public void addDescription(String description){
    	this.description= this.description.concat("\n" + description);
    }
    
    protected String getDescription(){
    	return this.description;
    }
    
    protected void setDescription(String description){
    	this.description = description;
    }
    
    public GameStatus getEventStatus(){
    	return this.eventStatus;
    }
    
    public abstract int executeChoice(int number);
}
