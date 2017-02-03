package gui;

import java.awt.Graphics2D;

public abstract class GameGUI 
{
	protected DefaultScreen defaultScreen;
	
	public GameGUI(DefaultScreen defaultScreen){
		this.defaultScreen = defaultScreen;
	}
	
	public abstract void draw(Graphics2D g2d);
}
