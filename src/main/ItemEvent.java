package main;

import java.util.Collection;

import itens.ItemType;

public class ItemEvent extends Event{

	ItemType item;
	private String NullDescription = "Não existe mais itens no local";
	
	public ItemEvent(String description, Collection<Choice> choices, ItemType itemType){
		 super(description, choices, GameStatus.DIALOG);
		 this.item = itemType;
	}
	
	@Override
	public int executeChoice(int number) {
		// TODO Auto-generated method stub
		for(Choice choice : choices){
			if(choice.getNumber() == number){
				if(choice instanceof ItemChoice){
					choices.remove(choice);
					return -1;
				}
				else
					return choice.getEventIndex();
			}
			
			
		}
		
		return -1;
	}
	public void SetNullDescription(){
		this.setDescription(this.NullDescription);
	}
	
}
