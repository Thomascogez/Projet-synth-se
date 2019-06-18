public class CaseHexa
{
	private CaseHexa[] casesVoisines;
	private Contenu contenuCase;
	private String id;

	public CaseHexa(String infoCase)
	{
		String[] s = infoCase.split("-");
		if (s[0].equals("N")) {id = " ";}
		else{id = s[0];}
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
		if(contenuCase == null)
			id = " ";
		if(contenuCase instanceof Robot)
			id = "R";
		if(contenuCase instanceof Cristal)
			id = "C";
	}

	public String getid(){return this.id;}

	public Contenu getContenu()
	{
		return contenuCase;
	}
}
