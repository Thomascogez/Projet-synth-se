import java.util.ArrayList;

/**
 * Classe Base
 * @author Quentin BERNARDIN
 * @author Mathieu BOIREAU
 * @author Thomas  COGEZ--ALLIX
 * @author Patrice MAISONNEUVE
 * @version 06-21-2019
 */

public class Base extends Contenu
{

	private ArrayList<Cristal> cristaux;
	private int numJoueur;

	public Base(int numJoueur)
	{
		this.cristaux = new ArrayList <Cristal>();
		this.numJoueur = numJoueur+1;
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

	public int getNumJoueur()
	{
		return this.numJoueur;
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
