package characters;

public class Thief extends Player {
	
	public Thief(int level, String name) {
		super(level, name, PlayerType.THIEF, new String[] { "Atack", "Ataque Preciso", "Retalhar" } );
		gerarStatus();
	}
	
	public void levelUp(){
		super.levelUp();
		gerarStatus();
	}
	
	@Override
	protected void gerarStatus() {
		this.maxHp = 13 + (this.level * 3);
		this.hp = maxHp;
		this.maxMp = 2 + (this.level * 2);
		this.mp = maxMp;
		this.strenght = 2;
		this.dexterity = 2;
		this.magic = 1;
		
		this.attack = 2 + (this.level) + (this.strenght/2) + (this.dexterity/2);
		this.defense = 2 + this.level;
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
