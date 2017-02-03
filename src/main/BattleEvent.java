package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import characters.Character;
import characters.Enemy;
import characters.Goblin;
import characters.Player;

public class BattleEvent extends Event 
{
	private int currentPlayer = 0;
	private Enemy[] enemies;
	private int lengthOfDescription = 0;
	
	public BattleEvent(String description, Collection<Choice> choice, Enemy[] characters)
	{
		super(description, choice, GameStatus.BATTLE);
		this.addDescription("Inimigos:");
		for(int i = 0; i < characters.length; i++){
			this.addDescription(characters[i].getName() + " Hp: " + characters[i].getHp());
		}
		this.enemies = characters;
		
		Choice a = new BlankChoice("", 0);
		for(Choice c:choice)
			a = c;
		
		Choice endOfBattleChoices = new BlankChoice("Continuar", 0);
		endOfBattleChoices.defineNumber(this.choices.size());
		Choice endOfBattleChoices1 = new BlankChoice("Continuar",0);
		endOfBattleChoices1.defineNumber(this.choices.size());
		Choice endOfBattleChoices2 = new BlankChoice("Continuar", 0);
		endOfBattleChoices2.defineNumber(this.choices.size());
		this.choices.add(endOfBattleChoices);
		this.choices.add(endOfBattleChoices1);
		this.choices.add(endOfBattleChoices2);
	}
	
	public void nextPlayer()
	{
		/*currentPlayer++;
		if(currentPlayer > Book.getInstance().getAllEvents().length)
			currentPlayer = 0;*/
	}
	
	public int getCurrentPlayer(){
		return currentPlayer;
	}
	
	@Override
	public int executeChoice(int number){
		return -1;
		/*System.out.println(choice.getDescription());
		if(choice.getDescription().equals("Continuar")){
			this.currentPlayer = 0;
			Book.getInstance().setCurrentEvent(Book.getInstance().getAllEvents()[choice.getEventIndex()]);
			for(int i = 0; i < enemies.length; i++)
				enemies[i].revive();
			this.setDescription("");
		}
		else
			this.battle(choice.getNumber());*/
	}

	
	public void battle(int index){
		/*Player player = Book.getInstance().getPlayers()[currentPlayer];
		player.attack(index, this.enemies);
		this.addDescription(player.getName() + " usou " + player.getSkillsNames()[index%3] ); 
		
		if(enemies[0].getHp() <= 0){
			this.addDescription(this.enemies[0].getName() + " Hp: " + 0);
			this.addDescription("Goblin veio a falecer");
			this.currentPlayer = Book.getInstance().getPlayers().length;
			return;
			//Book.getInstance().setCurrentEvent(Book.getInstance().getAllEvents()[((ArrayList<Choice>)this.choices).get(0).getEventIndex()]);
		}
		
		this.addDescription(this.enemies[0].getName() + " Hp: " + this.enemies[0].getHp());
		Random random = new Random();
		int r = random.nextInt(10);
		if(r < 5)
		{
			int playerSorted = random.nextInt(Book.getInstance().getPlayers().length);
			enemies[0].attack(Book.getInstance().getPlayers()[playerSorted]);
			this.addDescription(enemies[0].getName() + " Atacou " + Book.getInstance().getPlayers()[playerSorted].getName());
			this.addDescription(Book.getInstance().getPlayers()[playerSorted].getName() + " Hp: " + Book.getInstance().getPlayers()[playerSorted].getHp());
			Book.getInstance().characterStatsGUI.repaintCharacterStats(playerSorted);
		}
			
		this.nextPlayer();*/
	}
	@Override
	public void addDescription(String description){
		super.addDescription(description);
		this.lengthOfDescription++;
		this.moveDescription();
	}
	
	private void moveDescription(){
		if(this.lengthOfDescription >= 6){
			for(int i = 0; i < this.getDescription().length(); i++){
				if(this.getDescription().charAt(i) == '\n'){
					this.lengthOfDescription--;
					this.setDescription(this.getDescription().substring(i + 1));
					break;
				}
			}
		}
	}

}
