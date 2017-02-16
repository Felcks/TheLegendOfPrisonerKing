package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import javax.swing.plaf.ProgressBarUI;
import javax.swing.plaf.synth.SynthScrollBarUI;

import characters.Character;
import characters.Enemy;
import characters.Goblin;
import characters.Player;

public class BattleEvent extends Event 
{
	private Enemy[] enemies;
	private Player[] players;
	private int lengthOfDescription = 0;
	private int currentAttacker = 0;
	private int currentPlayerAttacker = 0;
	private int probabilityOfEnemyTurn = 0;
	
	private static final String BATTLEOVER_DESCRIPTION = "Uma grande batalha já foi travada neste local!";
	private Boolean battleOver = false;
	
	public BattleEvent(String description, Collection<Choice> choice, Player[] players, Enemy[] enemies, int probabilityOfEnemyTurn)
	{
		super(description, choice, GameStatus.BATTLE);
		this.enemies = enemies;
		this.players = players;
		this.probabilityOfEnemyTurn = probabilityOfEnemyTurn;
		
		//Pq isso estava aqui!?
		/*Choice a = new BlankChoice("", 0);
		for(Choice c:choice)
			a = c;*/
		
		Choice endOfBattleChoices = new BlankChoice("Voltar", 0);
		endOfBattleChoices.defineNumber(this.choices.size());
		Choice endOfBattleChoices1 = new BlankChoice("Voltar",0);
		endOfBattleChoices1.defineNumber(this.choices.size());
		Choice endOfBattleChoices2 = new BlankChoice("Voltar", 0);
		endOfBattleChoices2.defineNumber(this.choices.size());
		this.choices.add(endOfBattleChoices);
		this.choices.add(endOfBattleChoices1);
		this.choices.add(endOfBattleChoices2);
		
		this.writeStartDescription();
		this.writeTurnDescription();
	}
	
	private void writeStartDescription(){
		this.addDescription("!----------------------BATALHA----------------------!");
		this.addDescription("Inimigo(s): ");
		for(int i = 0; i < enemies.length; i++){
			this.addDescription(enemies[i].getName() + " Hp:" + enemies[i].getHp() + "  ");
		}
		
	}
	
	private void writeTurnDescription(){
		if(this.currentAttacker < this.players.length)
			this.addDescription(this.players[this.currentAttacker].getName() + " Turno: ");
		else
			this.addDescription(this.enemies[this.currentAttacker - this.players.length].getName() + " Turno: ");
	}
	
	public void nextAttacker()
	{
		Random random = new Random();
		int sortedAttacker = random.nextInt(100);
		if(sortedAttacker < probabilityOfEnemyTurn){
			//É a vez de algum inimigo!
			//Veremos qual:
			int enemySorted = random.nextInt(this.enemies.length);
			this.currentAttacker = this.players.length + enemySorted;
		}
		else{
			if(currentPlayerAttacker < this.players.length - 1){
				this.currentPlayerAttacker += 1;
			}
			else{
				this.currentPlayerAttacker = 0;
			}

			this.currentAttacker = this.currentPlayerAttacker;
		}
	}
	
	@Override
	public int executeChoice(int index){
		return this.battle(index);
	}

	
	public int battle(int index){
		//Se o atacante for um player:
		if(this.currentAttacker < this.players.length){
			Player player = this.players[this.currentAttacker];
			int enemyAttacked = player.attack(index, this.enemies);
			
			if(enemyAttacked >= 0){
				this.addDescriptionNoSpace("usou " + player.getSkillsNames()[index] + " em " + enemies[enemyAttacked].getName());
				this.addDescription(enemies[enemyAttacked].getName() + " Hp:" + enemies[enemyAttacked].getHp() + "  ");
			}
			else if(enemyAttacked == -1){
				this.addDescriptionNoSpace("usou " + player.getSkillsNames()[index] + " em todos os inimigos");
				for(int i = 0; i < enemies.length; i++){
					this.addDescription(enemies[i].getName() + " Hp:" + enemies[i].getHp() + "  ");
				}
			}
			
			if(enemyAttacked >= 0){
				if(enemies[enemyAttacked].getHp() <= 0){
					this.addDescription(enemies[enemyAttacked].getName() + " derrotado");
					if(this.checkIfThereIsEnemyAlive(enemies) == false){
						this.currentAttacker = this.players.length + this.enemies.length;
						this.addDescription("Fim da batalha!");
						return -1;
					}
				}
			}
		}
		//Se o atacante for um inimigo
		else if(this.currentAttacker >= this.players.length && this.currentAttacker < this.players.length + this.enemies.length){
			int eIndex = this.currentAttacker - this.players.length;
			Enemy enemy = this.enemies[eIndex];
			enemy.attack(this.players[0]);
			this.addDescriptionNoSpace("atacou " + this.players[0].getName());
		}
		else{
			return finishBattle();
		}
		
		
		this.nextAttacker();
		this.writeTurnDescription();
		
		return -1;
	}
	@Override
	public void addDescription(String description){
		super.addDescription(description);
		this.lengthOfDescription++;
		this.moveDescription();
	}
	
	private void moveDescription(){
		if(this.lengthOfDescription >= 5){
			for(int i = 0; i < this.getDescription().length(); i++){
				if(this.getDescription().charAt(i) == '\n'){
					this.lengthOfDescription--;
					this.setDescription(this.getDescription().substring(i + 1));
					break;
				}
			}
		}
	}
	
	public int getCurrentAttacker(){
		return this.currentAttacker;
	}
	
	private int finishBattle(){
		for(Choice choice: choices){
			if(choice.getDescription() == "Voltar"){
				this.setDescription(BATTLEOVER_DESCRIPTION);
				this.battleOver = true;
				return choice.getEventIndex(); 
			}
		}
		return -1;
	}
	
	private Boolean checkIfThereIsEnemyAlive(Enemy[] enemies){
		for(int i = 0; i < enemies.length; i++){
			if(enemies[i].getHp() > 0)
				return true;
		}
		
		return false;
	}
	

}
