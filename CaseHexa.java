public class CaseHexa
{
	private CaseHexa[] casesVoisines;
	private Contenu contenuCase;
	private String id;
	private static int numIncre = 0;
	private int num;

	public CaseHexa()
	{
		contenuCase = null;
		id          = " ";
		casesVoisines = new CaseHexa[6];
		num = CaseHexa.numIncre++;
	}

	public CaseHexa[] getVoisines()
	{
		return casesVoisines;
	}

	public int getNum()
	{
		return this.num;
	}

	public void setVoisin(CaseHexa caseHexa, int orientation)
	{
		this.casesVoisines[orientation]=caseHexa;
	}

	public void lierCase(CaseHexa caseHex, int orientation)
	{
		this.setVoisin(caseHex, orientation);
		caseHex.setVoisin(this, (orientation+3)%6);
	}

	public void setContenu(Contenu contenuCase)
	{
		System.out.println("BUG?");
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
