package characters;

public abstract class Character {
	//comentario do luis
	protected int attack, defense;
	protected int hp, maxHp;
	protected String name;
	protected int level;
	
	public Character(int level, String name){
		this.name = name;
		this.level = level;
	}

	public String getName(){
		return name;
	}
	
	protected void levelUp(){
		this.level += 1;
	}
	
	public int getHp(){
		return this.hp;
	}
	
    public boolean isAlive() {
        if(this.hp > 0)
            return true;

        return false;
    }

    public void takeDamage(int attack) {
        this.hp -= attack;
    }
    
    public int getAttack(){
    	return this.attack;
    }
    
    public void revive(){
    	this.hp = maxHp;
    }
    
    protected abstract void gerarStatus();

}
