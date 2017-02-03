package characters;

public enum EnemyType {
	
	GOBLIN(0);
	
	private int index;
	
	EnemyType(int index){
		this.index = index;
	}
	
	public int getIndex(){
		return this.index;
	}

}
