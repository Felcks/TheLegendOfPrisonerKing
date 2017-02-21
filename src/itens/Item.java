package itens;

import javax.swing.ImageIcon;

import gui.AllImages;

public abstract class Item 
{
	private String name;
	private String description;
	private ItemType type;
	private ImageIcon icon;
	
	public Item(String name, String description, ItemType itemType){
		this.name = name;
		this.description = description;
		this.type = itemType;
		this.icon = AllImages.getInstance().getItensImage(itemType);
	}
	
	public String getName(){
		return name;
	}
	
	public ItemType getType(){
		return type;
	}
	
	public ImageIcon getIcon(){
		return this.icon;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public abstract void use();
}
