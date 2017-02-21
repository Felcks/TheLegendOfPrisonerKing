package gui;

import javax.swing.JPanel;

public class DefaultScreen extends JPanel
{
	private GUIManager guiManager;
	private String nameOfScreen;

	public DefaultScreen(GUIManager guiManager, String nameOfScreen){
		this.guiManager = guiManager;
		this.nameOfScreen = nameOfScreen;
	}
	
	public String getNameOfScreen() {
		return nameOfScreen;
	}
	
	public GUIManager getGUIManager(){
		return this.guiManager;
	}
}
