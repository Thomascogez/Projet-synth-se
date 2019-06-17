public class CaseHexa
{
	private CaseHexa[] casesVoisines;

	public CaseHexa(CaseHexa[] casesVoisines)
	{
		for(int i=0; i<6; i++)
			this.casesVoisines[i] = casesVoisines[i];
	}

	public CaseHexa()
	{
		this(new CaseHexa[6]);
	}
}