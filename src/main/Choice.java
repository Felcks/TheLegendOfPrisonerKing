package main;

import characters.Character;

public abstract class Choice 
{
    private String description;
    private int eventIndex;
    private int number;
    
    public Choice(String description, int eventIndex) 
    {
        this.eventIndex = eventIndex;
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void defineNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public int getEventIndex() {
        return this.eventIndex;
    }
    
}
