package main;

import java.util.Collection;

public class Book {
	
    private int eventActually;
    private String description;
    
    public Book() {
    	this.description = "A lenda do rei prisioneiro";
    }

    public void resetHistory() {
        this.eventActually = 0;
    }
    
    public String showHistory(Event[] event) {
        return event[eventActually].history();
    }

    public boolean isTheEnd(Event[] event) {
        return event[eventActually].isEndEvent();
    }

    public String showHistoryBook(){
        return this.description;
    }
    
    public int getEventActually(){
    	return this.eventActually;
    }
    
    public void setEventActually(int newEvent){
    	this.eventActually = newEvent;
    }
    
    /*
    public boolean nextEvent(int number){
        Choice choice = this.selectChoice(number);
        if(choice != null) {
        	// this.getCurrentEvent().executeChoice(choice);
            return true;
        }

        return false;
    }

    public Choice selectChoice(int number) {
       // return this.eventActually.findChoice(number);
    }

    public Collection<Choice> nextEvents() {
        // return this.eventActually.nextEvents();
    }*/
    
}
