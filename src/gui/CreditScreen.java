package gui;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import utilities.CreditButtonListener;

import java.awt.ComponentOrientation;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CreditScreen extends DefaultScreen {

	private JButton back;
	
	public CreditScreen(GUIManager guiManager, String nameOfScreen) {
		super(guiManager, nameOfScreen);
		// TODO Auto-generated constructor stub
		
		this.setLayout(null);
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		
		JButton title = new JButton("Créditos");
		title.setBounds(100, 25, 600, 100);
		title.setFont(title.getFont().deriveFont(35.0F));
		this.add(title);
	
		JLabel joao = new JLabel("João Vitor de Almeida");
		joao.setBounds(250, 350, 600, 100);
		joao.setFont(joao.getFont().deriveFont(25.0F));
		this.add(joao);
		
		JLabel luis = new JLabel("Luis Antônio Junior");
		luis.setBounds(250, 400, 600, 100);
		luis.setFont(luis.getFont().deriveFont(25.0F));
		this.add(luis);
		
		JLabel matheus = new JLabel("Matheus Felipe");
		matheus.setBounds(250, 450, 600, 100);
		matheus.setFont(matheus.getFont().deriveFont(25.0F));
		this.add(matheus);
		
		JButton names = new JButton();
		names.setBounds(220, 350, 370, 200);
		this.add(names);
		
		JButton comp2 = new JButton("Atividade Acadêmica - Computação II - UFRRJ");
		comp2.setFont(comp2.getFont().deriveFont(20.0F));
		comp2.setBounds(100, 170, 600, 50);
		this.add(comp2);
		
		JButton bruno = new JButton("Professor: Bruno Dembogurski");
		bruno.setFont(bruno.getFont().deriveFont(20.0F));
		bruno.setBounds(100, 220, 600, 50);
		this.add(bruno);
		
		
		this.back = new JButton("Voltar");
		this.back.setBounds(0, 590, 100, 50);
		this.add(this.back);
	}
	
	public void setButtonListener(CreditButtonListener cbl){
		this.back.addActionListener(cbl);
	}

}
