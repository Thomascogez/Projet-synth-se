package crystaux;

public class CaseHexa
{
	private CaseHexa[] casesVoisines;
	private IContenu   contenuCase;

	public CaseHexa(CaseHexa[] casesVoisines)
	{
		for(int i=0; i<6; i++)
			this.casesVoisines[i] = casesVoisines[i];
		contenuCase = null;
	}

	public CaseHexa()
	{
		this(new CaseHexa[6]);
	}

	public void setVoisin(int cote, CaseHexa autreCase)
	{
		if(0<=cote && cote<6 &&
		   autreCase != null && autreCase.casesVoisines[(cote+3)%6] == null)
		{
			this.casesVoisines[cote] = autreCase;
			autreCase.casesVoisines[(cote+3)%6] = this;
		}
	}

	public void setContenu(IContenu contenuCase)
	{
		this.contenuCase = contenuCase;
	}

	public IContenu getContenu()
	{
		return contenuCase;
	}
}