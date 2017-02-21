package characters;

public abstract class Player extends Character {

	protected int mp, maxMp;
	protected int strenght, dexterity, magic;
	protected PlayerType playerType;
	protected String[] skillsNames;
	
    public Player(int level, String name , PlayerType playerType, String[] skillsNames) {
        super(level, name); 
        this.playerType = playerType;
        this.skillsNames = skillsNames;
    }
    
    public PlayerType getPlayerType () {
    	return this.playerType;
    }
    
    public String[] getSkillsNames(){
    	return this.skillsNames;
    }
    
    public String[] getSkillsNamesForButtons(){
    	String[] skillsNamesForButtons = new String[skillsNames.length];
    	for(int i = 0; i < skillsNamesForButtons.length; i++){
    		skillsNamesForButtons[i] = skillsNames[i];
    	}
    	skillsNamesForButtons[1] = skillsNamesForButtons[1].concat(" (1 de mp)");
    	skillsNamesForButtons[2] = skillsNamesForButtons[2].concat(" (2 de mp)");
    	
    	return skillsNamesForButtons;
    }
    
    public abstract void normalAtack(Character enemy);
	
	public abstract void skillOne(Character enemy);
	
	public abstract void skillTwo(Character[] enemies);
	
	//enemiesAttacked --> Ataca o primeiro inimigo que estiver vivo
	//retorna -1 caso ataque todos os inimigos
	public int attack(int indexOfAttack, Character[] enemies){
		int enemiesAttacked = 0;
		
		for(int i = 0; i < enemies.length; i++){
			if(enemies[i].getHp() > 0){
				enemiesAttacked = i;
				break;
			}
		}
		if(indexOfAttack == 0)
			normalAtack(enemies[enemiesAttacked]);
		else if(indexOfAttack == 1){
			if(this.mp >= 1)
				skillOne(enemies[enemiesAttacked]);
			else
				return -2;
		}
		else if(indexOfAttack == 2){
			if(this.mp >= 2){
				skillTwo(enemies);
				enemiesAttacked = -1;
			}
			else return -2;
		}
		
		return enemiesAttacked;
	}
	
	
	public int[] getAttributes(){
		int[] attributes = new int[5];
		attributes[0] = this.hp;
		attributes[1] = this.mp;
		attributes[2] = this.strenght;
		attributes[3] = this.magic;
		attributes[4] = this.dexterity;
		
		return attributes;
	}
	
	public int[] getMaxHpAndMP(){
		int[] attributes = new int[2];
		attributes[0] = this.maxHp;
		attributes[1] = this.maxMp;
		return attributes;
	}
	
}
