package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import itens.Item;
import itens.ItemType;
import main.Book;

public class InventoryGUI extends GameGUI
{	
	private JButton[] inventoryButtons;
	private JTextField inventoryText;
	private JButton mapButton;
	private JTextField mapText;

	public InventoryGUI(DefaultScreen defaultScreen)
	{
		super(defaultScreen);
		
		//INVENTÁRIO
		this.inventoryButtons = new JButton[9];
		for(int i = 0; i < 3; i++)
		{
		   for(int j = 0; j < 3; j++)
		   {
			   this.inventoryButtons[i * 3 + j] = new JButton("");
			   this.inventoryButtons[i * 3 + j].setBounds(25 + j * 50 , 50 + i * 50, 48, 48);
			   this.defaultScreen.add(inventoryButtons[i * 3 + j], 0);
			   inventoryText = new JTextField();
			}
		}
		inventoryText.setText("Inventário");
		inventoryText.setBounds(25,30,150,20);
		inventoryText.setHorizontalAlignment(SwingConstants.CENTER);
		this.defaultScreen.add(inventoryText);
		
		//MAPA
		this.mapButton = new JButton();
		this.mapButton.setBounds(200, 50, 150, 150);
		//this.mapButton.setIcon(AllImages.getInstance().getMapImage(0));
		this.defaultScreen.add(this.mapButton);
		
		this.mapText = new JTextField("Mapa");
		this.mapText.setBounds(200, 30, 150, 20);
		this.mapText.setEditable(false);
		this.mapText.setHorizontalAlignment(SwingConstants.CENTER);
		this.defaultScreen.add(this.mapText);
	}
	
	@Override 
	public void draw(Graphics2D g)
	{
		
	}
	
	public void repaintInventory(Item[] itens){
		for(int i = 0; i < this.inventoryButtons.length; i++){
			if(itens[i] != null){
				this.inventoryButtons[i].setIcon(itens[i].getIcon());
			}
		}
	}
}
