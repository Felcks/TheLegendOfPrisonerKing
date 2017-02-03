package main;

import java.util.Locale;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import napkin.NapkinLookAndFeel;
import gui.GUIManager;
import gui.Screen;
import gui.AllImages;

public class Main 
{
	public static void main(String[] args) 
	{
		Locale.setDefault(new Locale("pt", "BR"));
		Screen.start();
		AllImages.getInstance().start();
		
		// START GAME
		GameManager gameManager = new GameManager();
		
		// START THEME
	    try 
	    {  
     		UIManager.setLookAndFeel(new NapkinLookAndFeel()); 
     		SwingUtilities.updateComponentTreeUI(gameManager.getGUIManager().window);
	    } 
	    catch (Exception ex) 
	    {  
	    	ex.printStackTrace();
	    }    
	    
	}
}

