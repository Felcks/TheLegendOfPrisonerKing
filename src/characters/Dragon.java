package characters;

public class Dragon extends Enemy{
	
	public Dragon(int level){
		super(level, EnemyType.DRAGON);	
		gerarStatus();
	}
	
	public Dragon(int level, String name){
		super(level, EnemyType.DRAGON, name);	
		gerarStatus();
	}
	
	@Override
	protected void gerarStatus() {
		this.hp = 20 + (2 * this.level);
		this.maxHp = this.hp;
		this.attack = 5 + (1 * this.level);
		this.defense = 0;
		
	}
	
	public int getHp(){
		return this.hp;
	}
	
	@Override
	public void attack(Player player){
		player.takeDamage(this.attack);
	}
	
}
