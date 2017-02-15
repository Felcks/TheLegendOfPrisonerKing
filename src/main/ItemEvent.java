package main;

import java.util.Collection;

import itens.ItemType;

public class ItemEvent extends Event{

	private static String ITEMOVER_DESCRIPTION = "Não existe mais itens no local!";
	
	public ItemEvent(String description, Collection<Choice> choices){
		 super(description, choices, GameStatus.DIALOG);
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
	
	public void SetNullDescription(){
		this.setDescription(ITEMOVER_DESCRIPTION);
	}
	
}
