package itens;

public enum ItemType 
{
	BOOK(0), ROPE(1), AXE(2), KEY(3), POTION(4), CANDLE(5), MAGNIFYING_GLASS(6), FIREWOOD(7), BINOCULARS(8),  MAP(9);
	
	private int index;
	
	ItemType(int index){
		this.index = index;
	}
	
	public int getIndex(){
		return this.index;
	}
}
