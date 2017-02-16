package characters;

public class Mage extends Player{

	public Mage(int level, String name) {
		super(level, name, PlayerType.MAGE, new String[] { "Atack", "Bola de Fogo", "Terremoto" } );
		gerarStatus();
	}
	
	@Override
	protected void gerarStatus() {
		this.maxHp = 10 + (this.level * 1);
		this.hp = maxHp;
		this.maxMp = 4 + (this.level * 4);
		this.mp = maxMp;
		this.strenght = 1;
		this.dexterity = 1;
		this.magic = 3;
		
		this.attack = 1 + (this.level) + (this.strenght/4) + (this.dexterity/3);
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
