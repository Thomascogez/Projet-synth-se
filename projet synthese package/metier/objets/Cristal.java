package metier.objets;

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
	
	/** La valeur du cristal. */
	private int valeur;
	
	/** L'indice de la position de base du cristal
	 * (utile pour la pile de cristaux à rajouter durant la partie).
	 */
	private int indPositionDeBase;

	/**
	 * Instancie le cristal.
	 *
	 * @param valeur La valeur
	 */
	public Cristal(int valeur)
	{
		this.valeur = valeur;
	}

	/**
	 * Sets la position de base.
	 *
	 * @param indCaseHexa l'indice de la position de base
	 */
	public void setPositionDeBase(int indCaseHexa)
	{
		indPositionDeBase = indCaseHexa;
	}

	/**
	 * Renvoie la position de base.
	 *
	 * @return le position de base
	 */
	public int getPositionDeBase()
	{
		return indPositionDeBase;
	}

	/**
	 * Renvoie la valeur du cristal.
	 *
	 * @return La valeur
	 */
	public int getValeur()
	{
		return valeur;
	}
}
