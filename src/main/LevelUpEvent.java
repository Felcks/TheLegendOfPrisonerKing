package main;

import java.util.Collection;

public class LevelUpEvent extends Event {

private static String ITEMOVER_DESCRIPTION = "Você fez um grande discurso. Todos ganharam status e estão reanimados!";
	
	public LevelUpEvent(String description, Collection<Choice> choices){
		 super(description, choices, GameStatus.DIALOG);
	}
	
	public LevelUpEvent(String description, Collection<Choice> choices, int mapPos){
		 super(description, choices, GameStatus.DIALOG, mapPos);
	}
	
	@Override
	public int executeChoice(int number) {
		for(Choice choice : choices){
			if(choice.getNumber() == number){
				if(number == 1){
					choices.remove(choice);
					this.setDescription(ITEMOVER_DESCRIPTION);
					return -3;
				}
				else
					return choice.getEventIndex();
			}	
		}
		return -1;
	}
	
	public int executeChoice2(int number, boolean x){
		System.out.println(number);
		for(Choice choice : choices){
			System.out.println(choice.getNumber());
			if(choice.getNumber() == number){
				System.out.println(choice.getEventIndex());
				return choice.getEventIndex();
			}
		}
			return 0;
	}
	
	public void SetNullDescription(){
		this.setDescription(ITEMOVER_DESCRIPTION);
	}
}
