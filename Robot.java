public class Robot
{
	private String   couleur;
	private CaseHexa case;
	private int      dir;
	private Cristal  cristalPorte;

	public Robot(String couleur, CaseHexa case, int dir)
	{
		this.couleur = couleur;
		this.case    = case;

		if(dir<0 || dir>=6)
			dir = 0;
		this.dir     = dir;
		cristalPorte = null;
	}

	private void tourner(char direction)
	{
		if(direction == 'd' || direction == 'D')
			dir = (dir+1)%6;
		if(direction == 'g' || direction == 'G')
			dir = (dir-1)%6;
	}

	// PAS ENCORE POSSIBLE DE POUSSER LES ROBOTS ET CRISTAUX
	private void avancer()
	{
		CaseHexa[] casesVoisines = case.getVoisines();
		if(casesVoisines[dir].getContenu()==null)
		{
			case.setContenu(null);
			casesVoisines[dir].setContenu(this);
			case = casesVoisines[dir];
		}
	}

	private void charger()
	{
		CaseHexa[] casesVoisines = case.getVoisines();
		if(casesVoisines[dir].getContenu() instance of Cristal)
		{
			cristalPorte = casesVoisines[dir].getContenu();
			casesVoisines[dir].setContenu(null);
		}

		if(casesVoisines[dir].getContenu() instance of Robot)
		{
			Robot autreRobot = casesVoisines[dir].getContenu();
			this.cristalPorte = autreRobot.cristalPorte;
			autreRobot.cristalPorte = null;
		}
	}

	private void deposer()
	{
		CaseHexa[] casesVoisines = case.getVoisines();
		// Cas hors du plateau
		if(casesVoisines[dir] == null)
			return;
		// Cas Robot chargé
		if(casesVoisines[dir].getContenu() instance of Robot &&
		   casesVoisines[dir].getContenu().cristalPorte != null )
			return;
		// Cas Cristal présent
		if(casesVoisines[dir].getContenu() instance of Cristal)
			return;


		if(casesVoisines[dir].getContenu() == null)
			casesVoisines[dir].setContenu(cristalPorte);

		if(casesVoisines[dir].getContenu() instance of Robot)
			;
	}
}