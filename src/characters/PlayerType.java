package characters;

public enum PlayerType {
	
	WARRIOR(0), MAGE(1), ARCHER(2), THIEF(3);
	
	private int index;
	
	PlayerType(int index){
		this.index = index;
	}
	
	public int getIndex(){
		return this.index;
	}
}
