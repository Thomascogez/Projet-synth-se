package metier.objets;

import java.util.ArrayList;

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

	/** La liste des cristaux contenus dans la base. */
	private ArrayList<Cristal> cristaux;
	/** Le numéro du joueur à qui appartient la base. */
	private int numJoueur;

	/**
	 * Instancie une base
	 * @param numJoueur le numéro du joueur à qui appartient la base
	 */
	public Base(int numJoueur)
	{
		this.cristaux = new ArrayList <Cristal>();
		this.numJoueur = numJoueur+1;
	}

	/**
	 * Ajoute un cristal dans la base.
	 *
	 * @param c Le cristal à ajouter
	 */
	public void ajouterCristal(Cristal c)
	{
		this.cristaux.add(c);
	}

	/**
	 * Renvoie le numéro du joueur
	 */
	public int getNumJoueur()
	{
		return this.numJoueur;
	}

	/**
	 * Renvoie le nombre de points de l'ensemble des cristaux de la base
	 *
	 * @return le nombre de points
	 */
	public int getTotalpoint()
	{
		int retour = 0;
		for (Cristal c  :cristaux ) {
			retour += c.getValeur();
		}
		return retour;
	}

}
