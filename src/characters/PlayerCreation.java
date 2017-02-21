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
		this.names = new String[]{ "Steiner", "Vivi", "Zidane", "Freya"};
		
		this.players = new Player[amountOfPlayers];
		

		this.players[0] = new Warrior(0, names[0]);
		this.players[1] = new Mage(0, names[1]);
		this.players[2] = new Thief(0, names[2]);
		this.players[3] = new Archer(0, names[3]);
		
	}
}
