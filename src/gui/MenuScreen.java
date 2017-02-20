package gui;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import utilities.DialogButtonListener;
import utilities.MenuButtonListener;

import java.awt.ComponentOrientation;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MenuScreen extends DefaultScreen 
{
	JButton play;
	JButton credit;
	public MenuScreen(GUIManager guiManager, String nameOfScreen) {
		super(guiManager, nameOfScreen);
		
		this.setLayout(null);
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		
		JLabel title = new JLabel("A Lenda do Rei Prisioneiro", SwingConstants.CENTER);
		title.setBounds(100, 25, 600, 100);
		title.setFont(title.getFont().deriveFont(35.0F));
		this.add(title);
		
		JButton image = new JButton();
		image.setBounds(50, 150, 700, 200);
		image.setIcon(new ImageIcon("Images/Menu2.png"));
		this.add(image);
		
		play = new JButton("Jogar");
		play.setBounds(200, 400, 400, 100);
		play.setFont(play.getFont().deriveFont(50.0F));
		this.add(play);
		
		credit = new JButton("Creditos");
		credit.setBounds(300, 550, 200, 50);
		credit.setFont(credit.getFont().deriveFont(15.0F));
		this.add(credit);
		
	}
	
	public void setMenuButtonListener(MenuButtonListener[] dbls){
		this.play.addActionListener(dbls[0]);
		this.credit.addActionListener(dbls[1]);
;	}
	
	
	
}
