/**
 * Classe CaseHexa.
 *
 * @author Quentin BERNARDIN
 * @author Mathieu BOIREAU
 * @author Thomas  COGEZ--ALLIX
 * @author Patrice MAISONNEUVE
 * @version 06-21-2019
 */

public class CaseHexa
{
	
	/** Les cases voisines dans un tableau de cases. */
	private CaseHexa[] casesVoisines;
	
	/** Le contenu de la case (une base, un cristal ou un robot) */
	private Contenu contenuCase;
	
	/** La manière dont est affiché le contenu de la case dans l'affichage */
	private String id;
	
	/** Le numéro séquentiel auto-incrémenté */
	private static int numIncre = 0;
	
	/** Le numéro de la case */
	private int num;

	/**
	 * Instancie la case.
	 */
	public CaseHexa()
	{
		contenuCase = null;
		id          = " ";
		casesVoisines = new CaseHexa[6];
		num = CaseHexa.numIncre++;
	}

	/**
	 * Renvoie le tableau de cases voisines de la case
	 *
	 * @return les cases voisines
	 */
	public CaseHexa[] getVoisines()
	{
		return casesVoisines;
	}

	/**
	 * Renvoie le numéro de la case
	 *
	 * @return le numéro de la case
	 */
	public int getNum()
	{
		return this.num;
	}

	/**
	 * Sets un voisin de la case avec sa position par rapport à la case.
	 *
	 * @param caseHexa La case voisine
	 * @param orientation La position de la voisine par rapport à la case.
	 */
	public void setVoisin(CaseHexa caseHexa, int orientation)
	{
		this.casesVoisines[orientation]=caseHexa;
	}

	/**
	 * Lier une case.
	 *
	 * @param caseHex the case hex
	 * @param orientation the orientation
	 */
	public void lierCase(CaseHexa caseHex, int orientation)
	{
		this.setVoisin(caseHex, orientation);
		caseHex.setVoisin(this, (orientation+3)%6);
	}

	/**
	 * Sets le contenu de la case (une base, un cristal ou un robot).
	 *
	 * @param contenuCase Le nouveau contenu
	 */
	public void setContenu(Contenu contenuCase)
	{
		this.contenuCase = contenuCase;
		if(contenuCase == null)
		id = " ";
		if(contenuCase instanceof Robot)
		id = "R";
		if(contenuCase instanceof Cristal)
		id = "C";
		if(contenuCase instanceof Base)
		id = "B";
	}

	/**
	 * Renvoie la chaine d'affichage de la case
	 *
	 * @return id
	 */
	public String getid(){return this.id;}

	/**
	 * Renvoie le contenu.
	 *
	 * @return Le contenu
	 */
	public Contenu getContenu()
	{
		return contenuCase;
	}
}