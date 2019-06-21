/**
 * Classe Cristal
 * @author Quentin BERNARDIN
 * @author Mathieu BOIREAU
 * @author Thomas  COGEZ--ALLIX
 * @author Patrice MAISONNEUVE
 * @version 06-21-2019
 */

public class Cristal extends Contenu
{
	private int valeur;

	private Cristal(int valeur)
	{
		this.valeur = valeur;
	}

	public static Cristal creerCristal(int valeur)
	{
		if(valeur>=2 && valeur<=4)
			return new Cristal(valeur);
		return null;
	}

	public int getPositionDeBase(){
		//TODO:position de la case de départ
		return 0;
	}
	public int getValeur()
	{
		return valeur;
	}
}
