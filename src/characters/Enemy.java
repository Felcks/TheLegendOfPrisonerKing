package characters;

public abstract class Enemy extends Character {
	
	private EnemyType enemyType;
	
    public Enemy(int level, EnemyType enemyType){
    	super(level, enemyType.toString());
    	this.enemyType = enemyType;
    }
    
    public abstract void attack(Player player);
    
}
