<<<<<<< HEAD
package crystaux;

=======
>>>>>>> ef65c56851a0a06ae8fb46e32a21f30ad30dfb36
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