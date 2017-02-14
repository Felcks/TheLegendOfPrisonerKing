package main;

import characters.Player;
import characters.PlayerCreation;
import gui.GUIManager;
import utilities.DialogButtonListener;

public class GameManager 
{
	private GameStatus gameStatus;
	private EventsCreation eventsCreation;
	private PlayerCreation playersCreation;
	
	private Player[] players;
	private Event[] events;
	private Book book;
	
	private GUIManager guiManager;
	private DialogButtonListener[] dialogButtonListeners;
	
	private int currentPlayer = 0;
	
	public GameManager(){
		this.guiManager = new GUIManager();
		this.gameStatus = gameStatus.DIALOG;
		
		this.playersCreation = new PlayerCreation();
		this.players = playersCreation.getPlayers();
		
		this.eventsCreation = new EventsCreation(this.players);
		this.events = eventsCreation.getAllEvents();
		
		this.book = new Book();
		this.book.resetHistory();
		
		this.repaintDialog();
		this.dialogButtonListeners = new DialogButtonListener[4];
		for(int i = 0; i < 4; i++)
			this.dialogButtonListeners[i] = new DialogButtonListener(this, i);
		
		this.setDialogListeners();
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
	
	private void nextPlayer(){
		currentPlayer++;
		//if(currentPlayer >= this.getPlayersAlive().length)
			//currentPlayer = 0;
	}
	
	public GUIManager getGUIManager(){
		return this.guiManager;
	}
	
	private void repaintDialog(){
		this.guiManager.getGameScreen().getDialogGUI().repaintDialog(this.getCurrentEvent().choices, this.getCurrentEvent().getDescription());
	}
	
	private void repaintDialogForBattle(){
		this.guiManager.getGameScreen().getDialogGUI().repaintDialogForBattle(this.getCurrentEvent().choices, 
														this.getCurrentEvent().getDescription(), this.currentPlayer);
	}
	
	private void setDialogListeners(){
		this.guiManager.getGameScreen().getDialogGUI().setDialogButtonListener(this.dialogButtonListeners);
	}
	
	public void dialogButtonClicked(int index){
		int nextEvent = this.getCurrentEvent().executeChoice(index);
		if(nextEvent != this.book.getEventActually() && nextEvent >= 0){
			this.book.setEventActually(nextEvent);
			if(this.getCurrentEvent() instanceof BlankEvent)
				this.repaintDialog();
			else{
				this.repaintDialogForBattle();
				this.nextPlayer();
			}
		}
	}
}
