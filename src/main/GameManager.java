package main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import characters.Player;
import characters.PlayerCreation;
import gui.GUIManager;
import itens.ItemType;
import utilities.CreditButtonListener;
import utilities.DialogButtonListener;
import utilities.MenuButtonListener;
import itens.Inventory;

public class GameManager 
{
	private GameStatus gameStatus;
	private EventsCreation eventsCreation;
	private PlayerCreation playersCreation;
	
	private Player[] players;
	private Event[] events;
	private Inventory inventory;
	private Book book;
	
	private GUIManager guiManager;
	private DialogButtonListener[] dialogButtonListeners;
	private MenuButtonListener[] menuButtonListeners;
	private CreditButtonListener creditButtonListener;
	
	private AudioClip music;
	private int delay = 10000;
	
	public GameManager(){
		this.guiManager = new GUIManager();
		this.gameStatus = gameStatus.DIALOG;
		
		this.playersCreation = new PlayerCreation();
		this.players = playersCreation.getPlayers();
		
		this.eventsCreation = new EventsCreation(this.players);
		this.events = eventsCreation.getAllEvents();
		
		this.inventory = new Inventory();
		
		this.book = new Book();
		this.book.resetHistory();
		
		this.repaintDialog();
		this.dialogButtonListeners = new DialogButtonListener[4];
		for(int i = 0; i < 4; i++)
			this.dialogButtonListeners[i] = new DialogButtonListener(this, i);
		
		this.menuButtonListeners = new MenuButtonListener[4];
		for(int i = 0; i < 2; i++)
			this.menuButtonListeners[i] = new MenuButtonListener(this, i);
		
		this.creditButtonListener = new CreditButtonListener(this, 0);
		
		this.setDialogListeners();
		this.startCharactersStatsGUI();		
		
	}
	
	public void setGameStatus(GameStatus gameStatus){
		this.gameStatus = gameStatus;
	}
	
	public GameStatus getGameStatus(){
		return this.gameStatus;
	}
	
	public Event getStartEvent(){
		return this.events[0];
	}
	
	public Event[] getAllEvents(){
		return this.events;
	}
	
	private Event getCurrentEvent(){
		return this.events[this.book.getEventActually()];
	}
	
	public Player[] getPlayers(){
		return this.playersCreation.getPlayers();
	}
	
	public GUIManager getGUIManager(){
		return this.guiManager;
	}
	
	private void repaintCharactersStats(){
		this.guiManager.getGameScreen().getCharacterStatsGUI().repaintCharacterStats(this.players);
	}
	
	private void startCharactersStatsGUI(){
		this.guiManager.getGameScreen().getCharacterStatsGUI().start(this.players);
	}
	
	private void repaintDialog(){
		this.guiManager.getGameScreen().getDialogGUI().repaintDialog(this.getCurrentEvent().choices, this.getCurrentEvent().getDescription());
	}
	
	private void repaintDialogForBattle(){
		int currentPlayer = 0;
		if(this.getCurrentEvent() instanceof BattleEvent)
			currentPlayer = ((BattleEvent)this.getCurrentEvent()).getCurrentAttacker();
		
		this.guiManager.getGameScreen().getDialogGUI().repaintDialogForBattle(this.getCurrentEvent().choices, 
														this.getCurrentEvent().getDescription(), currentPlayer);
		
		this.guiManager.getGameScreen().getCharacterStatsGUI().repaintCharactersImages(players, currentPlayer);
	}
	
	private void repaintInventory(){
		this.guiManager.getGameScreen().getInventoryGUI().repaintInventory(inventory.getItens());
	}
	
	private void repaintMap(int index){
		this.guiManager.getGameScreen().getInventoryGUI().repaintMap(inventory.getItens(), index);
	}
	
	private void setDialogListeners(){
		this.guiManager.getGameScreen().getDialogGUI().setDialogButtonListener(this.dialogButtonListeners);
		this.guiManager.getMenuScreen().setMenuButtonListener(this.menuButtonListeners);
		this.guiManager.getCreditScreen().setButtonListener(this.creditButtonListener);
	}
	
	public void dialogButtonClicked(int index){
		if(can == false)
			return;
		
		can = false;
		//nextEvent é o index próximo evento
		//ItemEvents retornam o index do item a ser pego
		//BattleEvent retorna -1 se a batlhar continuar ou um index de cena maior que zero, se for o fim da batalha
		int nextEvent = this.getCurrentEvent().executeChoice(index);
		
		if(this.getCurrentEvent() instanceof BlankEvent){
			this.book.setEventActually(nextEvent);
		}
		else if(this.getCurrentEvent() instanceof BattleEvent){
			if(nextEvent >= 0){
				this.book.setEventActually(nextEvent);
			}
			else
				this.repaintCharactersStats();
		}
		else if(this.getCurrentEvent() instanceof ItemEvent){
			ItemEvent itemEvent = (ItemEvent)this.getCurrentEvent();
			if(index == 0){
				this.book.setEventActually(nextEvent);
			}
			else{
				this.inventory.addItem(nextEvent);
				this.repaintInventory();
				((ItemEvent) this.getCurrentEvent()).SetNullDescription();
				if(nextEvent == 9){
					for(Choice choice : this.getCurrentEvent().choices){
						this.getCurrentEvent().choices.remove(choice);
						break;
					}
					((ItemEvent) this.getCurrentEvent()).choices.add(new BlankChoice("Prosseguir", 17));
				}
			}
		}
		
		if(this.getCurrentEvent() instanceof BlankEvent || this.getCurrentEvent() instanceof ItemEvent){
			repaintDialog();
			//Para ele repintar todos os players para o padrao
			this.guiManager.getGameScreen().getCharacterStatsGUI().repaintCharactersImages(players, 99);
		}
		else if(this.getCurrentEvent() instanceof BattleEvent)
			repaintDialogForBattle();
		
		if(this.getCurrentEvent().getMapPos() >= 0)
			this.repaintMap(this.getCurrentEvent().getMapPos());
		
		can = true;
	}
	
	Boolean can = true;
	public void menuButtonClicked(int index){
		if(index == 0)
			this.guiManager.changeToScreen("gameScreen");
		else
			this.guiManager.changeToScreen("creditScreen");
	}
	
	public void creditButtonClicked(){
		this.guiManager.changeToScreen("menuScreen");
	}
}
