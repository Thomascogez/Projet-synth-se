import java.util.ArrayList;

/**
* Base
*/
public class Base extends Contenu
{

	private ArrayList<Cristal> cristaux;

	public Base()
	{
		this.cristaux = new ArrayList <Cristal>();
	}

	/**
	* Methode permettant d'ajouter un crystal dans la base
	*
	* @param c la crystal a ajouter
	*/
	public void ajouterCristal(Cristal c)
	{
		this.cristaux.add(c);
	}

	public ArrayList<Cristal> getCristaux()
	{
		return cristaux;
	}

	public int getNbCristaux(int valeur)
	{
		int cpt = 0;
		for (Cristal c : this.cristaux)
		{
			if (c.getValeur() == valeur)
				cpt++;
		}
		return cpt;
	}

	@Override
	public String toString()
	{
		return "Cristaux dans la base "+cristaux;
	}
}
