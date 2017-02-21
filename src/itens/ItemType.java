package itens;

public enum ItemType 
{
	BOOK(0, "Livro"), ROPE(1, "Corda"), AXE(2, "Machado"), KEY(3, "Chave"), POTION(4, "Poção"), CANDLE(5, "Vela"), 
	MAGNIFYING_GLASS(6, "Lupa"), FIREWOOD(7, "Lenha"), BINOCULARS(8, "Binóculos"),  MAP(9, "Mapa");
	
	private int index;
	private String name;
	
	ItemType(int index, String name){
		this.index = index;
		this.name = name;
	}
	
	public int getIndex(){
		return this.index;
	}
	
	public String getName(){
		return this.name;
	}
}
