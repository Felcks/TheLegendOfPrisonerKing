package utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.GameManager;

public class MenuButtonListener implements ActionListener {

	private GameManager gameManager;
	private int index;
	
	public MenuButtonListener(GameManager gameManager, int index){
		this.gameManager = gameManager;
		this.index = index;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.gameManager.menuButtonClicked(index);
	}

}
