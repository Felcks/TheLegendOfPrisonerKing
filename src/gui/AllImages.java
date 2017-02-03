package gui;

import javax.swing.ImageIcon;

import characters.PlayerType;
import itens.ItemType;

public class AllImages {
	
	private static AllImages allImages;
	private ImageIcon[] playersImages;
	//private ImageIcon[] enemiesImages;
	private ImageIcon[] itensImages;
	
	public static  AllImages getInstance(){
		if(allImages == null)
			allImages = new AllImages();
		
		return allImages;
	}
	
	public void start(){
		
	}
	
	private AllImages(){
		this.loadAllImages();
	}
	
	private void loadAllImages(){
		this.playersImages = new ImageIcon[PlayerType.values().length];
		this.playersImages[0] = new ImageIcon("Images/Characters/Warrior.png");
		this.playersImages[1] = new ImageIcon("Images/Characters/Mage.png");
	
		this.itensImages = new ImageIcon[ItemType.values().length];
		this.itensImages[0] = new ImageIcon("Images/Itens/Livro.png");
		this.itensImages[1] = new ImageIcon("Images/Itens/Corda.png");
		this.itensImages[2] = new ImageIcon("Images/Itens/Machadinha.png");
		this.itensImages[3] = new ImageIcon("Images/Itens/Chave.png");
		this.itensImages[4] = new ImageIcon("Images/Itens/Pocao.png");
		this.itensImages[5] = new ImageIcon("Images/Itens/Vela.png");
		this.itensImages[6] = new ImageIcon("Images/Itens/Lupa.png");
		this.itensImages[7] = new ImageIcon("Images/Itens/Lenha.png");
		this.itensImages[8] = new ImageIcon("Images/Itens/Binoculos.png");
		this.itensImages[9] = new ImageIcon("Images/Itens/Mapa.png");
	}
	
	public ImageIcon getPlayerImage(PlayerType playerType){
		return this.playersImages[playerType.getIndex()];
	}
	
	public ImageIcon getItensImage(ItemType itemType){
		return this.itensImages[itemType.getIndex()];
	}
}
