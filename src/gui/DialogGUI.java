package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.BattleEvent;
import main.Book;
import main.Choice;
import main.Event;
import main.GameStatus;
import utilities.DialogButtonListener;


public class DialogGUI extends GameGUI
{
	private JTextArea textArea;
	private JButton[] optionsButtons;
	
	public DialogGUI(DefaultScreen defaultScreen)
	{
		super(defaultScreen);
		
		this.textArea = new JTextArea();
		this.textArea.setLineWrap(true);
		this.textArea.setEditable(false);
		this.textArea.setBounds(210,305,380,100);
		this.defaultScreen.add(textArea);
		
		JTextField background = new JTextField();
		background.setBounds(200, 300, 400, 100);
		this.defaultScreen.add(background);
		
		this.optionsButtons = new JButton[4];
	    for(int i = 0; i < optionsButtons.length; i++)
	    {
	    	this.optionsButtons[i] = new JButton("");
	    	this.optionsButtons[i].setBounds(200,400 + (i * 50),400,50);
	    	this.defaultScreen.add(optionsButtons[i], 0);
	    }   
	}
	
	public void repaintDialog(Collection<Choice> choices, String description){
		int i = 0;
		for(Choice choice : choices){
			this.optionsButtons[i].setBackground(Color.gray.brighter());
			this.optionsButtons[i].setVisible(true);
			this.optionsButtons[i].setText(choice.getDescription());
			i++;
		}
		
		for(; i < this.optionsButtons.length; i++){
			this.optionsButtons[i].setVisible(false);
		}
		
		this.textArea.setText(description);
	}
	
	public void repaintDialogForBattle(Collection<Choice> choices, String description, int currentPlayer){
		int i = 0;
		for(Choice choice : choices){
			if(choice.getNumber() >= 3 * currentPlayer && choice.getNumber() < 3 * (currentPlayer+1)){
				this.optionsButtons[i].setBackground(Color.gray.brighter());
				this.optionsButtons[i].setVisible(true);
				this.optionsButtons[i].setText(choice.getDescription());
				i++;
			}
		}
		
		for(; i < this.optionsButtons.length; i++){
			this.optionsButtons[i].setVisible(false);
		}
		
		this.textArea.setText(description);
	}
	
	private void repaint(Book book)
	{
		/*this.textArea.setText(book.showHistory());
		int i = 0;
		GameScreen gameScreen = (GameScreen)defaultScreen;
		
		/*for(Choice choice:book.nextEvents()) 
		{
			this.optionsButtons[i].setBackground(Color.gray.brighter());
			this.optionsButtons[i].setVisible(true);
			this.optionsButtons[i].setText(choice.getDescription());
			i++;
		}*/
		/*       
		for(i = 0; i < 4; i++)
		{
			int currentPlayer = 0;
			int atacksAmount = 4;
			if(book.getCurrentEvent() instanceof BattleEvent){
				currentPlayer = ((BattleEvent)book.getCurrentEvent()).getCurrentPlayer();
				//atacksAmount = player.quantidadeDeAtaques --> se quiser
				atacksAmount = 3;
			}
			
			if(i  >= book.nextEvents().size() || i >= atacksAmount){
				break;
			}
			
			Choice choice = ((ArrayList<Choice>)book.nextEvents()).get(i + currentPlayer * atacksAmount);
			this.optionsButtons[i].setBackground(Color.gray.brighter());
			this.optionsButtons[i].setVisible(true);
			this.optionsButtons[i].setText(choice.getDescription());
			
		}
		
		for(; i < optionsButtons.length; i++)
		{
			this.optionsButtons[i].setVisible(false);
		}
		
		*/
		
		/*}
		else if(gameScreen.getGameStatus() == GameStatus.BATTLE)
		{
			BattleEvent battleEvent = (BattleEvent)book.getCurrentEvent();
			for(int j = (3 * battleEvent.getCurrentPlayer()); j < (3 * battleEvent.getCurrentPlayer()) + 3; j++) 
			{
				this.optionsButtons[i].setBackground(Color.gray.brighter());
				this.optionsButtons[i].setVisible(true);
				this.optionsButtons[i].setText( (String) ((Choice)((ArrayList)book.nextEvents()).get(i + (battleEvent.getCurrentPlayer() * 3))).getDescription());
				i++;
		    }
			
			this.optionsButtons[3].setVisible(false);*/
		
	}
	
	public void setDialogButtonListener(DialogButtonListener[] dbls){
		for(int i = 0; i < optionsButtons.length; i++){
	    	this.optionsButtons[i].addActionListener(dbls[i]);
		}
	}
	
	@Override
	public void draw(Graphics2D g2d)
	{

	}
	
	/*
	@Override
	public void actionPerformed(ActionEvent e)
	{
		int index = 0;
		for(index = 0; index < this.optionsButtons.length; index++)
			if(e.getSource().equals(this.optionsButtons[index]))
				break;
		
		/*
		int currentPlayer = 0;
		if(Book.getInstance().getCurrentEvent() instanceof BattleEvent){
			currentPlayer = ((BattleEvent)Book.getInstance().getCurrentEvent()).getCurrentPlayer();
		}
		
		Book.getInstance().nextEvent(index + (currentPlayer * 3));
		repaint(Book.getInstance());
	} */
}
