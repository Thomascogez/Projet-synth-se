// TODO: Auto-generated Javadoc
/**
 * Classe Cristal.
 *
 * @author Quentin BERNARDIN
 * @author Mathieu BOIREAU
 * @author Thomas  COGEZ--ALLIX
 * @author Patrice MAISONNEUVE
 * @version 06-21-2019
 */

public class Cristal extends Contenu
{
	
	/** The valeur. */
	private int valeur;
	
	/** The ind position de base. */
	private int indPositionDeBase;

	/**
	 * Instantiates a new cristal.
	 *
	 * @param valeur the valeur
	 */
	private Cristal(int valeur)
	{
		this.valeur = valeur;
	}

	/**
	 * Creer cristal.
	 *
	 * @param valeur the valeur
	 * @return the cristal
	 */
	public static Cristal creerCristal(int valeur)
	{
		if(valeur>=2 && valeur<=4)
			return new Cristal(valeur);
		return null;
	}

	/**
	 * Sets the position de base.
	 *
	 * @param indCaseHexa the new position de base
	 */
	public void setPositionDeBase(int indCaseHexa)
	{
		indPositionDeBase = indCaseHexa;
	}

	/**
	 * Gets the position de base.
	 *
	 * @return the position de base
	 */
	public int getPositionDeBase()
	{
		return indPositionDeBase;
	}

	/**
	 * Gets the valeur.
	 *
	 * @return the valeur
	 */
	public int getValeur()
	{
		return valeur;
	}
}
