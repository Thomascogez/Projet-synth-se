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
	private int indPositionDeBase;

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

	public void setPositionDeBase(int indCaseHexa)
	{
		indPositionDeBase = indCaseHexa;
	}

	public int getPositionDeBase()
	{
		return indPositionDeBase;
	}

	public int getValeur()
	{
		return valeur;
	}
}
