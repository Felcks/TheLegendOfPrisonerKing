package characters;

public enum EnemyType {
	
	GOBLIN(0, "Goblin"), MIMIC(1, "Mimico"), DRAGON(2, "Dragão"), KEFKA(3,"Kefka");
	
	private int index;
	private String name;
	
	EnemyType(int index, String name){
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
