package main;

import java.util.Collection;

public class RestartEvent extends Event{
	
	public RestartEvent(String description, Collection<Choice> choices) 
	{
        super(description, choices, GameStatus.DIALOG);
    }
	
	public RestartEvent(String description, Collection<Choice> choices, int mapPos) 
	{
        super(description, choices, GameStatus.DIALOG, mapPos);
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
