package main;

import java.util.Collection;

import itens.ItemType;

public class ItemEvent extends Event{

	private static String ITEMOVER_DESCRIPTION = "Não existem mais itens no local!";
	
	public ItemEvent(String description, Collection<Choice> choices){
		 super(description, choices, GameStatus.DIALOG);
	}
	
	public ItemEvent(String description, Collection<Choice> choices, int mapPos){
		 super(description, choices, GameStatus.DIALOG, mapPos);
	}
	
	@Override
	public int executeChoice(int number) {
		for(Choice choice : choices){
			if(choice.getNumber() == number){
				if(choice instanceof ItemChoice){
					int itemIndex = choice.getEventIndex();
					choices.remove(choice);
					return itemIndex;
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
