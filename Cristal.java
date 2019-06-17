package crystaux;

public class Cristal implements IContenu
{
	private int valeur;

	private Cristal(int valeur)
	{
		this.valeur = valeur;
	}

	public Cristal creerCristal(int valeur)
	{
		if(valeur>=2 && valeur<=4)
			return this(valeur);
		return null;
	}

	public int getValeur()
	{
		return valeur;
	}
}