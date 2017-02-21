package characters;

public class Kefka extends Enemy{
	
	public Kefka(int level){
		super(level, EnemyType.KEFKA);	
		gerarStatus();
	}
	
	public Kefka(int level, String name){
		super(level, EnemyType.KEFKA, name);	
		gerarStatus();
	}
	
	@Override
	protected void gerarStatus() {
		this.hp = 15 + (2 * this.level);
		this.maxHp = this.hp;
		this.attack = 3 + (1 * this.level);
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
