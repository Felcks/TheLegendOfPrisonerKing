package characters;

public class Archer extends Player{

	public Archer(int level, String name) {
		super(level, name, PlayerType.ARCHER, new String[] { "Atack", "Flecha concentrada", "Rajada de flechas" } );
		gerarStatus();
	}
	
	public void levelUp(){
		super.levelUp();
		gerarStatus();
	}
	
	@Override
	protected void gerarStatus() {
		this.maxHp = 12 + (this.level * 2);
		this.hp = maxHp;
		this.maxMp = 3 + (this.level * 3);
		this.mp = maxMp;
		this.strenght = 1;
		this.dexterity = 2;
		this.magic = 2;
		
		this.attack = 2 + (this.level) + (this.strenght/4) + (this.dexterity);
		this.defense = 1 + this.level;
	}

	@Override
	public void normalAtack(Character enemy) {
		enemy.takeDamage(this.attack);
	}

	@Override
	public void skillOne(Character enemy) {
		this.mp  -= 1;
		enemy.takeDamage(this.attack);
	}

	@Override
	public void skillTwo(Character[] enemies) {
		this.mp -= 2;
		for(int i = 0; i < enemies.length; i++){
			enemies[i].takeDamage(attack);
		}
	}

}
