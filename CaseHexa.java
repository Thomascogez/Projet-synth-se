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
	
	/** The cases voisines. */
	private CaseHexa[] casesVoisines;
	
	/** The contenu case. */
	private Contenu contenuCase;
	
	/** The id. */
	private String id;
	
	/** The num incre. */
	private static int numIncre = 0;
	
	/** The num. */
	private int num;

	/**
	 * Instantiates a new case hexa.
	 */
	public CaseHexa()
	{
		contenuCase = null;
		id          = " ";
		casesVoisines = new CaseHexa[6];
		num = CaseHexa.numIncre++;
	}

	/**
	 * Gets the voisines.
	 *
	 * @return the voisines
	 */
	public CaseHexa[] getVoisines()
	{
		return casesVoisines;
	}

	/**
	 * Gets the num.
	 *
	 * @return the num
	 */
	public int getNum()
	{
		return this.num;
	}

	/**
	 * Sets the voisin.
	 *
	 * @param caseHexa the case hexa
	 * @param orientation the orientation
	 */
	public void setVoisin(CaseHexa caseHexa, int orientation)
	{
		this.casesVoisines[orientation]=caseHexa;
	}

	/**
	 * Lier case.
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
	 * Sets the contenu.
	 *
	 * @param contenuCase the new contenu
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
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getid(){return this.id;}

	/**
	 * Gets the contenu.
	 *
	 * @return the contenu
	 */
	public Contenu getContenu()
	{
		return contenuCase;
	}
}
