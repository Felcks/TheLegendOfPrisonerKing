package main;

import itens.ItemType;

public class ItemChoice extends Choice{

	private ItemType itemType;
	
	public ItemChoice(String description, int eventIndex, ItemType itemType) {
		super(description, itemType.getIndex());
		this.itemType = itemType;
	}

}
