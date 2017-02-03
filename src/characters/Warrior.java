package characters;

public class Warrior extends Player{
	
	public Warrior(int level, String name){
		super(level, name , PlayerType.WARRIOR, new String[] { "Atack", "Dash", "Giro" } );
		gerarStatus();
	}
	
	public void levelUp(){
		super.levelUp();
		gerarStatus();
	}
	
	public void gerarStatus(){
		this.maxHp = 15 + (this.level * 4);
		this.hp = maxHp;
		this.maxMp = 1 + (this.level * 1);
		this.mp = maxMp;
		this.strenght = 2;
		this.dexterity = 2;
		this.magic = 1;
		
		this.attack = 4 + (this.level) + (this.strenght/2) + (this.dexterity/3);
		this.defense = 2 + this.level;
	}
	
	@Override
	public void normalAtack(Character enemy){
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
