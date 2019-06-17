public class CaseHexa
{
	private CaseHexa[] casesVoisines;
	private char id;

	public CaseHexa(Sting infoCase)
	{
		id = infoCase.charAt(0);
		contenuCase = null;
	}

	public CaseHexa()
	{
		this(new CaseHexa[6]);
	}

	public CaseHexa[] getVoisines()
	{
		return casesVoisines;
	}

	public void setVoisin(CaseHexa[] casesVoisines)
	{
		this.casesVoisines=casesVoisines;
	}

	public void setContenu(Contenu contenuCase)
	{
		this.contenuCase = contenuCase;
	}

	public char getid(){return this.id;}

	public Contenu getContenu()
	{
		return contenuCase;
	}
}
