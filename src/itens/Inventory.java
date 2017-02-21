package itens;

import java.awt.print.Book;

public class Inventory {

	private static final int MAX_ITENS = 9;
	private Item[] itens;
	
	public Inventory(){
		this.itens = new Item[9];
		
	}
	
	public Boolean hasPotions(){
		for(int i = 0; i < this.itens.length; i++){
			if(this.itens[i] instanceof Potion)
				return true;
		}
		
		return false;
	}
	
	public void removePotion(){
		for(int i = 0; i < this.itens.length; i++){
			if(this.itens[i] instanceof Potion)
				this.itens[i] = null;
		}
	}
	
	
	public Item[] getItens(){
		return this.itens;
	}
	
	public int addItem(int itemIndex){
		switch(itemIndex){
			case 3:
				return this.addItem(new Key());
			case 9:
				return this.addItem(new Map());
			case 4:
				return this.addItem(new Potion());
		}
		
		return -1;
	}
	
	public int addItem(Item item){
		for(int i = 0; i < this.itens.length; i++){
			if(itens[i] == null){
				this.itens[i] = item;
				return 0;
			}
		}
		
		return -1;
	}
}
