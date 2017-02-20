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
	private static final String GAMEOVER_DESCRIPTION = "Aniquilados...";
	private Boolean battleOver = false;
	
	public BattleEvent(String description, Collection<Choice> choices, Player[] players, Enemy[] enemies, 
			int probabilityOfEnemyTurn, int nextEvent)
	{
		super(description, choices, GameStatus.BATTLE);
		this.enemies = enemies;
		this.players = players;
		this.probabilityOfEnemyTurn = probabilityOfEnemyTurn;
		
		for(int i = 0; i < players.length; i++){
			Player player = players[i];
			String[] skillNames = player.getSkillsNamesForButtons();
			for(int j = 0; j < player.getSkillsNames().length; j++){
				Choice choice = new BlankChoice(skillNames[j], j);
				choice.defineNumber(i * player.getSkillsNames().length + j);
				this.choices.add(choice);
				
			}
		}
		
		for(int i = 0; i < enemies.length; i++){
			Choice choice1 = new BlankChoice("Continuar", 0);
			Choice choice2 = new BlankChoice("Continuar", 0);
			Choice choice3 = new BlankChoice("Continuar", 0);
			choice1.defineNumber(this.choices.size());
			choice2.defineNumber(this.choices.size());
			choice3.defineNumber(this.choices.size());
			
			
			this.choices.add(choice1);
			this.choices.add(choice2);
			this.choices.add(choice3);
		}
		
		
		Choice endOfBattleChoices = new BlankChoice("Fim de Batalha!", nextEvent);
		endOfBattleChoices.defineNumber(this.choices.size());
		Choice endOfBattleChoices1 = new BlankChoice("Fim de Batalha!",nextEvent);
		endOfBattleChoices1.defineNumber(this.choices.size());
		Choice endOfBattleChoices2 = new BlankChoice("Fim de Batalha!", nextEvent);
		endOfBattleChoices2.defineNumber(this.choices.size());
		this.choices.add(endOfBattleChoices);
		this.choices.add(endOfBattleChoices1);
		this.choices.add(endOfBattleChoices2);
		
		Choice gameOver1 = new BlankChoice("Game Over", 0);
		gameOver1.defineNumber(this.choices.size());
		Choice gameOver2 = new BlankChoice("Game Over",0);
		gameOver2.defineNumber(this.choices.size());
		Choice gameOver3 = new BlankChoice("Game Over", 0);
		gameOver3.defineNumber(this.choices.size());
		this.choices.add(gameOver1);
		this.choices.add(gameOver2);
		this.choices.add(gameOver3);
		
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
		if(sortedAttacker < this.probabilityOfEnemyTurn){
			//É a vez de algum inimigo!
			//Veremos qual:
			int enemySorted = 0;
			do{
				random.nextInt(this.enemies.length);
			}while(enemies[enemySorted].getHp() <= 0);
			
			this.currentAttacker = this.players.length + enemySorted;
		}
		else{
			do{
				if(currentPlayerAttacker < this.players.length - 1){
					this.currentPlayerAttacker += 1;
				}
				else{
					this.currentPlayerAttacker = 0;
				}
			}while(this.players[currentPlayerAttacker].getHp() <= 0);

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
			
			if(enemyAttacked == -2){
				return -1;
			}
			
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
			else if(enemyAttacked == -1){
				for(int i = 0; i < enemies.length; i++){
					if(enemies[i].getHp() <= 0){
						this.addDescription(enemies[i].getName() + " derrotado");
						if(this.checkIfThereIsEnemyAlive(enemies) == false){
							this.currentAttacker = this.players.length + this.enemies.length;
							this.addDescription("Fim da batalha!");
							return -1;
						}
					}
				}
			}
					
		}
		//Se o atacante for um inimigo
		else if(this.currentAttacker >= this.players.length && this.currentAttacker < this.players.length + this.enemies.length){
			Enemy enemy = this.enemies[currentAttacker - this.players.length];
			int sortedPlayer = 0;
			Random random = new Random();
			int tries = 0;
			do{
				sortedPlayer = random.nextInt(this.players.length);
				tries++;
				if(tries == 50){
					if(checkIFThereIsPlayerAlive() == false){
						this.currentAttacker = this.players.length + this.enemies.length + 1;
						this.addDescription("Fim de jogo!");
						return -1;
					}
				}
			}while(this.players[sortedPlayer].getHp() <= 0);
			
			enemy.attack(this.players[sortedPlayer]);
			this.addDescriptionNoSpace("atacou " + this.players[sortedPlayer].getName());
			
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
			if(choice.getDescription().equals("Fim de Batalha!")){
				this.setDescription(BATTLEOVER_DESCRIPTION);
				this.battleOver = true;
				return choice.getEventIndex(); 
			}
			else if(choice.getDescription().equals("Game Over")){
				this.setDescription(GAMEOVER_DESCRIPTION);
				this.battleOver = true;
				return 0;
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
	
	private Boolean checkIFThereIsPlayerAlive(){
		for(int i = 0; i < players.length; i++){
			if(players[i].getHp() > 0)
				return true;
		}
		
		return false;
	}
	

}
