package itens;

public abstract class Item 
{
	private String name;
	private String description;
	private ItemType type;
	
	public Item(String name, String description, ItemType itemType){
		this.name = name;
		this.description = description;
		this.type = itemType;
	}
	
	public String getName(){
		return name;
	}
	
	public ItemType getType(){
		return type;
	}
	
	public abstract void use();
}
