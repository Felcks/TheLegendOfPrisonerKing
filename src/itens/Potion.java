package itens;

public class Potion extends Item{
	
	public Potion()	{
		super("Poção", "É poção ou veneno!? Restaura 20 de hp", ItemType.POTION);
	}
	
	@Override
	public void use(){
		
	};

}
