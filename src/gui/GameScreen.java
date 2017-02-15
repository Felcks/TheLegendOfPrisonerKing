package gui;

import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Collection;

import main.Book;
import main.Choice;
import utilities.DialogButtonListener;


public class GameScreen extends DefaultScreen
{
	private InventoryGUI inventoryGUI;
	private BattleGUI battleGUI;
	private DialogGUI dialogGUI;
	private CharacterStatsGUI characterStatsGUI;
	
	public GameScreen(GUIManager guiManager, String nameOfScreen)
	{
		super(guiManager, nameOfScreen);
		
		this.setLayout(null);
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	
		this.inventoryGUI = new InventoryGUI(this);
		this.battleGUI = new BattleGUI(this);
		this.dialogGUI = new DialogGUI(this);
		this.characterStatsGUI = new CharacterStatsGUI(this);
	}
	
	@Override
    public void paintComponent(Graphics g) 
	{
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        					 RenderingHints.VALUE_ANTIALIAS_ON);
        
        this.inventoryGUI.draw(g2d);
        this.battleGUI.draw(g2d);
        this.inventoryGUI.draw(g2d);
        this.characterStatsGUI.draw(g2d);
	}
	
	public DialogGUI getDialogGUI(){
		return this.dialogGUI;
	}
	
	public InventoryGUI getInventoryGUI(){
		return this.inventoryGUI;
	}
	
	public CharacterStatsGUI getCharacterStatsGUI(){
		return this.characterStatsGUI;
	}

	
}
