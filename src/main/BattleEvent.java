package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

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
	
	private static final String BATTLEOVER_DESCRIPTION = "Uma grande batalha já foi travada neste local!";
	private Boolean battleOver = false;
	
	public BattleEvent(String description, Collection<Choice> choice, Player[] players, Enemy[] enemies)
	{
		super(description, choice, GameStatus.BATTLE);
		this.enemies = enemies;
		this.players = players;
		
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
		int sortedAttacker = random.nextInt(4);
		if(sortedAttacker <= 0){
			if(currentPlayerAttacker < this.players.length - 1){
				this.currentPlayerAttacker += 1;
			}
			else{
				this.currentPlayerAttacker = 0;
			}

			this.currentAttacker = this.currentPlayerAttacker;
		}
		else{
			//Primeigo goblin só pra teste
			this.currentAttacker = this.players.length;
		}
	}
	
	@Override
	public int executeChoice(int index){
		return this.battle(index);
	}

	
	public int battle(int index){
		if(this.currentAttacker < this.players.length){
			Player player = this.players[this.currentAttacker];
			player.attack(index, this.enemies);
			this.addDescriptionNoSpace("usou " + player.getSkillsNames()[index]);
			
			if(enemies[0].getHp() <= 0){
				this.addDescription(enemies[0].getName() + " derrotado");
				this.currentAttacker = this.players.length + this.enemies.length;
				return -1;
			}
			else if(index == 0 || index == 1){
				this.addDescription(enemies[0].getName() + " Hp:" + enemies[0].getHp() + "  ");
			}
			else{
				for(int i = 0; i < this.enemies.length; i++){
					this.addDescription(enemies[i].getName() + " Hp:" + enemies[i].getHp() + "  ");
				}
			}
			
			
		}
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

}
