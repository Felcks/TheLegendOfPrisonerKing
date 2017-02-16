package characters;

public enum PlayerType {
	
	WARRIOR(0), MAGE(1), THIEF(2), ARCHER(3);
	
	private int index;
	
	PlayerType(int index){
		this.index = index;
	}
	
	public int getIndex(){
		return this.index;
	}
}
