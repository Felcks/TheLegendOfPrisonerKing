package characters;

public class Goblin extends Enemy{
	
	public Goblin(int level){
		super(level, EnemyType.GOBLIN);	
		gerarStatus();
	}
	
	public Goblin(int level, String name){
		super(level, EnemyType.GOBLIN, name);	
		gerarStatus();
	}
	
	@Override
	protected void gerarStatus() {
		this.hp = 10 + (2 * this.level);
		this.maxHp = this.hp;
		this.attack = 3 + (1 * this.level);
		this.defense = 1;
		
	}
	
	public int getHp(){
		return this.hp;
	}
	
	@Override
	public void attack(Player player){
		player.takeDamage(this.attack);
	}
	
}
