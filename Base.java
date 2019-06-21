import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * Classe Base.
 *
 * @author Quentin BERNARDIN
 * @author Mathieu BOIREAU
 * @author Thomas  COGEZ--ALLIX
 * @author Patrice MAISONNEUVE
 * @version 06-21-2019
 */

public class Base extends Contenu
{

	/** The cristaux. */
	private ArrayList<Cristal> cristaux;

	/**
	 * Instantiates a new base.
	 */
	public Base()
	{
		this.cristaux = new ArrayList <Cristal>();
	}

	/**
	 * Methode permettant d'ajouter un crystal dans la base.
	 *
	 * @param c la crystal a ajouter
	 */
	public void ajouterCristal(Cristal c)
	{
		this.cristaux.add(c);
	}

	/**
	 * Gets the cristaux.
	 *
	 * @return the cristaux
	 */
	public ArrayList<Cristal> getCristaux()
	{
		return cristaux;
	}

	/**
	 * Gets the nb cristaux.
	 *
	 * @param valeur the valeur
	 * @return the nb cristaux
	 */
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

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString()
	{
		return "Cristaux dans la base "+cristaux;
	}
}
