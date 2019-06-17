<<<<<<< HEAD
package cristaux;

public class Cristal implements IContenu
=======
public class Cristal extends Contenu
>>>>>>> 1cd0e875bb977ba477a3b009f9d4b755c325fe88
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