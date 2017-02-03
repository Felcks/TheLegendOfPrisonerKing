package characters;

public class PlayerCreation {
	
	private int amountOfPlayers = 0;
	private String[] names;
	private Player[] players;
	
	public PlayerCreation(){
		this.createPlayers();
	}
	
	public Player[] getPlayers(){
		return this.players;
	}
	
	public void createPlayers()
	{
		this.amountOfPlayers = 4;
		this.names = new String[]{ "RYU", "VIVI", "STEINER", "FREYA"};
		
		this.players = new Player[amountOfPlayers];
		
		for(int i = 0; i < amountOfPlayers; i++){
				this.players[i] = new Warrior(0, names[i]);
		}
	}
}
