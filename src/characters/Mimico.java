package characters;

public class Mimico extends Enemy {
	
	public Mimico(int level){
		super(level, EnemyType.MIMIC);
		gerarStatus();
	}
	

	public Mimico(int level, String name){
		super(level, EnemyType.MIMIC, name);	
		gerarStatus();
	}

	@Override
	protected void gerarStatus() {
		this.hp = 15 + (2 * this.level);
		this.maxHp = this.hp;
		this.attack = 5 + (1 * this.level);
		this.defense = 1;
	}
	
	@Override
	public void attack(Player player) {
		player.takeDamage(this.attack);
	}

	
	public int getHp(){
		return this.hp;
	}
	

}
