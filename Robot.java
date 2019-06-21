// TODO: Auto-generated Javadoc
/**
 * Classe Robot.
 *
 * @author Quentin BERNARDIN
 * @author Mathieu BOIREAU
 * @author Thomas  COGEZ--ALLIX
 * @author Patrice MAISONNEUVE
 * @version 06-21-2019
 */

public class Robot extends Contenu
{
	
	/** The case hexa. */
	private CaseHexa caseHexa;
	
	/** The dir. */
	private int      dir;
	
	/** The cristal porte. */
	private Cristal  cristalPorte;
	
	/** The tab ordres. */
	private String[] tabOrdres;
	
	/** The num joueur. */
	private int numJoueur;

	/** The plateau. */
	private Plateau plateau; // uniquement pour la pile de cristaux

	/**
	 * Instantiates a new robot.
	 *
	 * @param plateau the plateau
	 * @param numJoueur the num joueur
	 */
	public Robot(Plateau plateau, int numJoueur)
	{
		if(dir<0 || dir>=6)
			dir = 0;
		cristalPorte = null;
		tabOrdres = new String[]{"","",""};
		this.plateau = plateau;
		this.numJoueur = numJoueur+1;
	}

	/**
	 * Equals.
	 *
	 * @param autre the autre
	 * @return true, if successful
	 */
	public boolean equals(Robot autre)
	{
		return this.caseHexa==autre.caseHexa &&
		       this.dir     ==autre.dir;
	}

	/**
	 * Gets the num joueur.
	 *
	 * @return the num joueur
	 */
	public int getNumJoueur()
	{
		return this.numJoueur;
	}

	/**
	 * Gets the dir.
	 *
	 * @return the dir
	 */
	public int getDir()
	{
		return dir;
	}

	/**
	 * Gets the ordres.
	 *
	 * @return the ordres
	 */
	public String[] getOrdres()
	{
		return tabOrdres;
	}

	/**
	 * Action.
	 */
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

	/**
	 * Action modif.
	 *
	 * @param tabOrdres the tab ordres
	 */
	public void actionModif(String[] tabOrdres)
	{
		this.tabOrdres = tabOrdres;
		action();
	}

	/**
	 * Gets the valeur cristal.
	 *
	 * @return the valeur cristal
	 */
	public int getValeurCristal()
	{
		if(this.cristalPorte!=null)
			return this.cristalPorte.getValeur();

		return 0;
	}

	/**
	 * Sets the case hexa.
	 *
	 * @param caseHexa the case hexa
	 * @param orientation the orientation
	 */
	// A n'utiliser qu'Ã  l'initialisation du plateau
	public void setCaseHexa(CaseHexa caseHexa, int orientation)
	{
		this.caseHexa = caseHexa;
		this.dir = orientation;
	}

	/**
	 * Tourner.
	 *
	 * @param direction the direction
	 */
	private void tourner(char direction)
	{
		System.out.println("direction "+dir+" - direction-1mod6 : "+((dir-1)%6));
		if(direction == 'd' || direction == 'D')
			dir = (dir==5)?dir=0:(dir+1)%6;
		if(direction == 'g' || direction == 'G')
			dir = (dir==0)?dir=5:(dir-1)%6;
		System.out.println("tourner "+dir);
	}

	/**
	 * Avancer.
	 */
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

	/**
	 * Charger.
	 */
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
	
	/**
	 * Sets the test ordres.
	 *
	 * @param tabTest the new test ordres
	 */
	public void setTestOrdres(String tabTest)
	{
		tabOrdres = tabTest.split(":");
		this.action();
	}

	/**
	 * Deposer.
	 */
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
			if(cristalPorte != null){
				plateau.ajouterNouvCristalDePile(cristalPorte.getPositionDeBase());
			}

			cristalPorte = null;
		}
	}
}
