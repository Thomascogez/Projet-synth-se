/**
 * Classe Robot
 * @author Quentin BERNARDIN
 * @author Mathieu BOIREAU
 * @author Thomas  COGEZ--ALLIX
 * @author Patrice MAISONNEUVE
 * @version 06-21-2019
 */

public class Robot extends Contenu
{
	private CaseHexa caseHexa;
	private int      dir;
	private Cristal  cristalPorte;
	private String[] tabOrdres;

	public Robot()
	{
		if(dir<0 || dir>=6)
			dir = 0;
		cristalPorte = null;
		tabOrdres = new String[]{"","",""};
	}

	public String[] getOrdres()
	{
		return tabOrdres;
	}

	public void action()
	{
		for(int i=0; i<tabOrdres.length; i++)
		{
			if(tabOrdres[i] != null)
			{
				tabOrdres[i] = tabOrdres[i].toUpperCase();

				if(tabOrdres[i].contains("TOURNER"))
					tourner(tabOrdres[i].charAt(tabOrdres[i].length()-1));

				if(tabOrdres[i].equals("AVANCER"))
					avancer();

				if(tabOrdres[i].equals("AVANCER2"))
				{
					avancer();
					avancer();
				}

				if(tabOrdres[i].equals("CHARGER"))
					charger();

				if(tabOrdres[i].equals("DEPOSER"))
					deposer();
			}
		
		}
	}

	public void actionModif(String[] tabOrdres)
	{
		this.tabOrdres = tabOrdres;
		action();
	}

	public int getValeurCristal()
	{
		if(this.cristalPorte!=null)
			return this.cristalPorte.getValeur()-1;

		return 0;
	}

	// A n'utiliser qu'à l'initialisation du plateau
	public void setCaseHexa(CaseHexa caseHexa, int orientation)
	{
		this.caseHexa = caseHexa;
		this.dir = orientation;
	}

	private void tourner(char direction)
	{
		System.out.println("direction "+dir+" - direction-1mod6 : "+((dir-1)%6));
		if(direction == 'd' || direction == 'D')
			dir = (dir==5)?dir=0:(dir+1)%6;
		if(direction == 'g' || direction == 'G')
			dir = (dir==0)?dir=5:(dir-1)%6;
		System.out.println("tourner "+dir);
	}

	private void avancer()
	{
		CaseHexa[] casesVoisines = caseHexa.getVoisines();

		if(casesVoisines[dir] != null)
		{
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
				if(casesVoisinesDeVoisine[dir] != null)
				{
					if(casesVoisinesDeVoisine[this.dir].getContenu() == null)
					{
						caseHexa.setContenu(null);
						casesVoisinesDeVoisine[this.dir].setContenu(casesVoisines[this.dir].getContenu());
						casesVoisines[dir].setContenu(this);
						caseHexa = casesVoisines[this.dir];
						if(casesVoisinesDeVoisine[dir].getContenu() instanceof Robot)
						{
							Robot r2 = (Robot)(casesVoisinesDeVoisine[this.dir].getContenu());
							r2.caseHexa = casesVoisinesDeVoisine[this.dir];
						}
					}
				}
			}
		}
	}

	private void charger()
	{
		CaseHexa[] casesVoisines = caseHexa.getVoisines();
		if(cristalPorte != null)
			return;
		if(casesVoisines[dir] == null)
			return;
		
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
	public void setTestOrdres(String tabTest)
	{
		tabOrdres = tabTest.split(":");
		this.action();
	}

	private void deposer()
	{
		CaseHexa[] casesVoisines = caseHexa.getVoisines();
		if(casesVoisines[dir]==null)
			return;

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
				this.cristalPorte = null;
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
