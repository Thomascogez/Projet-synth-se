public class CaseHexa
{
	private CaseHexa[] casesVoisines;
	private String id;

	public CaseHexa(String infoCase)
	{
		String[] s = infoCase.split("-");
		id = s[0];
		//contenuCase = null;
	}

	public CaseHexa[] getVoisines()
	{
		return casesVoisines;
	}

	public void setVoisins(CaseHexa[] casesVoisines)
	{
		this.casesVoisines=casesVoisines;
	}

	public void setContenu(Contenu contenuCase)
	{
		this.contenuCase = contenuCase;
	}

	public String getid(){return this.id;}

	public Contenu getContenu()
	{
		return contenuCase;
	}
}
