package characters;

public abstract class Enemy extends Character {
	
	private EnemyType enemyType;
	
    public Enemy(int level, EnemyType enemyType){
    	super(level, enemyType.getName());
    	this.enemyType = enemyType;
    }
    
    public Enemy(int level, EnemyType enemyType, String name){
    	super(level, name);
    	this.enemyType = enemyType;
    }
    
    
    public abstract void attack(Player player);
    
}
