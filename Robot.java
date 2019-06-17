public class Robot extends Contenu
{
	private CaseHexa caseHexa;
	private String   couleur;
	private int      dir;
	private Cristal  cristalPorte;

	public Robot(String couleur)
	{
		this.couleur = couleur;

		if(dir<0 || dir>=6)
			dir = 0;
		cristalPorte = null;
	}

	// A n'utiliser qu'à l'initialisation du plateau
	public void setCaseHexa(CaseHexa caseHexa)
	{
		this.caseHexa = caseHexa;
	}

	// A n'utiliser qu'à l'initialisation du plateau
	public void setDir(int dir)
	{
		this.dir = dir;
	}

	private void tourner(char direction)
	{
		if(direction == 'd' || direction == 'D')
			dir = (dir+1)%6;
		if(direction == 'g' || direction == 'G')
			dir = (dir-1)%6;
	}

	private void avancer()
	{
		CaseHexa[] casesVoisines = caseHexa.getVoisines();
		if(casesVoisines[dir].getContenu()==null)
		{
			caseHexa.setContenu(null);
			casesVoisines[dir].setContenu(this);
			caseHexa = casesVoisines[dir];
		}
		else if(casesVoisines[dir].getContenu() instanceof Cristal ||
		        casesVoisines[dir].getContenu() instanceof Robot     )
		{
			CaseHexa[] casesVoisinesDeVoisine = casesVoisines[dir].getVoisines();
			if(casesVoisinesDeVoisine[dir].getContenu() == null)
			{
				caseHexa.setContenu(null);
				casesVoisinesDeVoisine[dir].setContenu(casesVoisines[dir].getContenu());
				casesVoisines[dir].setContenu(this);
				caseHexa = casesVoisines[dir];
			}
		}
	}

	private void charger()
	{
		CaseHexa[] casesVoisines = caseHexa.getVoisines();
		if(casesVoisines[dir].getContenu() instanceof Cristal)
		{
			cristalPorte = (Cristal)(casesVoisines[dir].getContenu());
			casesVoisines[dir].setContenu(null);
		}

		if(casesVoisines[dir].getContenu() instanceof Robot)
		{
			Robot autreRobot = (Robot)(casesVoisines[dir].getContenu());
			this.cristalPorte = autreRobot.cristalPorte;
			autreRobot.cristalPorte = null;
		}
	}

	private void deposer()
	{
		// Sur une case vide
		if(casesVoisines[dir].getContenu() == null)
		{
			casesVoisines[dir].setContenu(cristalPorte);
			cristalPorte = null;
		}

		// Sur un robot libre
		else if(casesVoisines[dir].getContenu() instanceof Robot)
		{
			Robot autreRobot = (Robot)(casesVoisines[dir].getContenu());
			if(autreRobot.cristalPorte == null)
			{
				autreRobot.cristalPorte = this.cristalPorte;
				cristalPorte = null;
			}
		}

		// Dans une base
		else if(casesVoisines[dir].getContenu() instanceof Base)
		{
			Base base = (Base)(casesVoisines[dir].getContenu());
			base.ajouterCristal(cristalPorte);
			cristalPorte = null;
		}
	}
}