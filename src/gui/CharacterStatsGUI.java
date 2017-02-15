package gui;

import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import characters.Player;
import main.Book;

public class CharacterStatsGUI extends GameGUI{

	private JButton[] charactersAround;
	private JTextField[] charactersNames;
	private JLabel[][] charactersStats;
	
	public CharacterStatsGUI(DefaultScreen defaultScreen){
		super(defaultScreen);
		/*
		this.charactersAround = new JButton[Book.getInstance().getPlayers().length];
		this.charactersNames = new JTextField[Book.getInstance().getPlayers().length];
		this.charactersStats = new JLabel[Book.getInstance().getPlayers().length][];

		for(int i = 0; i < charactersAround.length; i++){
			this.charactersAround[i] = new JButton();
			this.charactersAround[i].setBounds(375 + i*105, 50, 100, 150);
			this.defaultScreen.add(this.charactersAround[i]);
			this.charactersAround[i].setIcon(LoadImages.getImage(Book.getInstance().getPlayers()[i].getImage()));
			this.charactersAround[i].setMargin(new Insets(50,50,50,50));
			this.charactersAround[i].setBorder(BorderFactory.createEmptyBorder(4, 4, 85, 4));
			
			JButton around = new JButton();
			around.setBounds(375 + i*105, 50, 100, 150);
			this.defaultScreen.add(around);
			
			this.charactersNames[i] = new JTextField(Book.getInstance().getPlayers()[i].getName());
			this.charactersNames[i].setBounds(375 + i*105, 30, 100, 20);
			this.charactersNames[i].setEditable(false);
			this.charactersNames[i].setHorizontalAlignment(SwingConstants.CENTER);
			this.defaultScreen.add(this.charactersNames[i]);
			
			String[] attributes = { "HP:", "MP:", "STR:", "INT:", "DEX:" };
			for(int j =0; j < attributes.length; j++){
				JLabel label = new JLabel(attributes[j]);
				label.setBounds(382 + i*105, 50 + j * 15, 100, 150);
				this.defaultScreen.add(label);
			}
			
			this.charactersStats[i] = new JLabel[attributes.length];
			Player player = Book.getInstance().getPlayers()[i];
			for(int j = 0; j < attributes.length; j++){
				this.charactersStats[i][j] = new JLabel("");
				int att = player.getAttributes()[j];
				String statsToShow = att + "";
				if(j < 2){
					this.charactersStats[i][j].setBounds(420 + i*105, 50 + j * 15, 100, 150);
					statsToShow = statsToShow.concat("/" + player.getMaxHpAndMP()[j]);
				}
				else{
					this.charactersStats[i][j].setBounds(430 + i*105, 50 + j * 15, 100, 150);
				}
				
				this.charactersStats[i][j].setText(statsToShow);
				this.defaultScreen.add(this.charactersStats[i][j]);
			}	
		}*/
	}
	
	public void start(Player[] players){
		this.charactersAround = new JButton[players.length];
		this.charactersNames = new JTextField[players.length];
		this.charactersStats = new JLabel[players.length][];

		for(int i = 0; i < charactersAround.length; i++){
			this.charactersAround[i] = new JButton();
			this.charactersAround[i].setBounds(375 + i*105, 50, 100, 150);
			this.defaultScreen.add(this.charactersAround[i]);
			this.charactersAround[i].setIcon(AllImages.getInstance().getPlayerImage(players[i].getPlayerType()));
			this.charactersAround[i].setMargin(new Insets(50,50,50,50));
			this.charactersAround[i].setBorder(BorderFactory.createEmptyBorder(4, 4, 85, 4));
			
			JButton around = new JButton();
			around.setBounds(375 + i*105, 50, 100, 150);
			this.defaultScreen.add(around);
			
			this.charactersNames[i] = new JTextField(players[i].getName());
			this.charactersNames[i].setBounds(375 + i*105, 30, 100, 20);
			this.charactersNames[i].setEditable(false);
			this.charactersNames[i].setHorizontalAlignment(SwingConstants.CENTER);
			this.defaultScreen.add(this.charactersNames[i]);
			
			String[] attributes = { "HP:", "MP:", "STR:", "INT:", "DEX:" };
			for(int j =0; j < attributes.length; j++){
				JLabel label = new JLabel(attributes[j]);
				label.setBounds(382 + i*105, 50 + j * 15, 100, 150);
				this.defaultScreen.add(label);
			}
			
			this.charactersStats[i] = new JLabel[attributes.length];
			Player player = players[i];
			for(int j = 0; j < attributes.length; j++){
				this.charactersStats[i][j] = new JLabel("");
				int att = player.getAttributes()[j];
				String statsToShow = att + "";
				if(j < 2){
					this.charactersStats[i][j].setBounds(420 + i*105, 50 + j * 15, 100, 150);
					statsToShow = statsToShow.concat("/" + player.getMaxHpAndMP()[j]);
				}
				else{
					this.charactersStats[i][j].setBounds(430 + i*105, 50 + j * 15, 100, 150);
				}
				
				this.charactersStats[i][j].setText(statsToShow);
				this.defaultScreen.add(this.charactersStats[i][j]);
			}
		}
	
	}
	
	public void repaintCharacterStats(Player[] players){
		for(int i = 0; i < players.length; i++){
			Player player = players[i];
			int amountOfAttributes = player.getAttributes().length;
			
			for(int j = 0; j < amountOfAttributes; j++){
				int att = player.getAttributes()[j];
				String statsToShow = att + "";
				if(j < 2){
					this.charactersStats[i][j].setBounds(420 + i*105, 50 + j * 15, 100, 150);
					statsToShow = statsToShow.concat("/" + player.getMaxHpAndMP()[j]);
				}
				else{
					this.charactersStats[i][j].setBounds(430 + i*105, 50 + j * 15, 100, 150);
				}
				
				this.charactersStats[i][j].setText(statsToShow);
				this.defaultScreen.add(this.charactersStats[i][j]);
			}
		}
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
	}
}
