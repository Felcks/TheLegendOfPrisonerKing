package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIManager {

	public JFrame window;
	private JPanel cards;
	private DefaultScreen gameScreen;
	private DefaultScreen menuScreen;
	
	public GUIManager(){
		this.createWindow();
		this.createCards();
		this.createScreens();
	}
	
	private void createWindow(){
		this.window = new JFrame("frame");
		this.window.setSize(800, 640);
		this.window.setResizable(false);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setVisible(true);
		this.window.setTitle("The Legend of Prisoner King");
		this.window.setLocationRelativeTo(null);
	}
	
	private void createCards(){
		this.cards = new JPanel(new CardLayout());
		this.window.getContentPane().add(this.cards, BorderLayout.CENTER); 	
	}
	
	private void createScreens(){
		this.menuScreen = new MenuScreen(this, "menuScreen");
		this.gameScreen = new GameScreen(this, "gameScreen");
		

		this.cards.add(this.menuScreen , menuScreen.getNameOfScreen());
		this.cards.add(this.gameScreen, gameScreen.getNameOfScreen());
	}
	
	public void changeToScreen(String screenName){
		CardLayout cl = (CardLayout)(this.cards.getLayout());
		cl.show(cards, screenName);	
	}
	
	public JPanel getCards(){
		return this.cards;
	}
	
	public GameScreen getGameScreen(){
		return (GameScreen) this.gameScreen;
	}
	
	public MenuScreen getMenuScreen(){
		return (MenuScreen) this.menuScreen;
	}


}
