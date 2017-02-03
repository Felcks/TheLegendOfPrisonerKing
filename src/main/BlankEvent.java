package main;

import java.util.Collection;

import characters.Character;

public class BlankEvent extends Event
{
	public BlankEvent(String description, Collection<Choice> choices) 
	{
        super(description, choices, GameStatus.DIALOG);
    }
	
	@Override
	public int executeChoice(int number){
		for(Choice choice : choices){
			if(choice.getNumber() == number)
				return choice.getEventIndex();
		}
		
		return -1;
	}

}