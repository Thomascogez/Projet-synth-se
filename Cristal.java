public class Cristal extends Contenu
{
	private int valeur;

	private Cristal(int valeur)
	{
		this.valeur = valeur;
	}

	public Cristal creerCristal(int valeur)
	{
		if(valeur>=2 && valeur<=4)
			return new Cristal(valeur);
		return null;
	}

	public int getValeur()
	{
		return valeur;
	}
}