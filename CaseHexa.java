public class CaseHexa
{
	private CaseHexa[] casesVoisines;
	private Contenu contenuCase;
	private String id;

	public CaseHexa()
	{
		contenuCase = null;
		id          = " ";
		casesVoisines = new CaseHexa[6];
	}

	public CaseHexa[] getVoisines()
	{
		return casesVoisines;
	}

	public void setVoisin(CaseHexa caseHexa, int orientation)
	{
		this.casesVoisines[orientation]=caseHexa;
	}

	public void lierCase(CaseHexa caseHex, int orientation)
	{
		this.setVoisin(caseHex, orientation);
		caseHex.setVoisin(this, orientation);
	}

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

	public String getid(){return this.id;}

	public Contenu getContenu()
	{
		return contenuCase;
	}
}
