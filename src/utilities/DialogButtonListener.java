package utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

import main.GameManager;

public class DialogButtonListener implements ActionListener{
	
	private GameManager gameManager;
	private int index;
	
	public DialogButtonListener(GameManager gameManager, int index){
		this.gameManager = gameManager;
		this.index = index;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.gameManager.dialogButtonClicked(index);
	}

}
