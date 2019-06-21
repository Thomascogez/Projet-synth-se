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
	
	/** La case du robot */
	private CaseHexa caseHexa;
	
	/** La direction du robot */
	private int      dir;
	
	/** Le cristal porté par le robot */
	private Cristal  cristalPorte;
	
	/** Le tableau d'ordres du robot */
	private String[] tabOrdres;
	
	/** Le numéro du joueur à qui appartient le robot */
	private int numJoueur;

	/** Le plateau. */
	private Plateau plateau; // uniquement pour la pile de cristaux

	/**
	 * Instancie un robot.
	 *
	 * @param plateau Le plateau
	 * @param numJoueur Le numéro du joueur joueur
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
	 * Vérifie l'équivalence de deux robots.
	 *
	 * @param autre L'autre robot
	 * @return vrai si le robot est équivalent à l'autre robot
	 */
	public boolean equals(Robot autre)
	{
		return this.caseHexa==autre.caseHexa &&
		       this.dir     ==autre.dir;
	}

	/**
	 * Renvoie le numéro du joueur
	 *
	 * @return le numéro du joueur
	 */
	public int getNumJoueur()
	{
		return this.numJoueur;
	}

	/**
	 * Renvoie la direction du robot.
	 *
	 * @return la direction
	 */
	public int getDir()
	{
		return dir;
	}

	/**
	 * Renvoie sous la forme d'un tableau de chaines.
	 *
	 * @return les ordres du robot
	 */
	public String[] getOrdres()
	{
		return tabOrdres;
	}

	/**
	 * Déclenche les ordres du robot.
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
	 * Change les ordres avant de les déclencher
	 *
	 * @param tabOrdres Les nouveaux ordres dans un tableau de chaines
	 */
	public void actionModif(String[] tabOrdres)
	{
		this.tabOrdres = tabOrdres;
		action();
	}

	/**
	 * Renvoie la valeur du cristal porté.
	 *
	 * @return la valeur du cristal
	 */
	public int getValeurCristal()
	{
		if(this.cristalPorte!=null)
			return this.cristalPorte.getValeur();

		return 0;
	}

	/**
	 * Sets la case et l'orientation du robot.
	 *
	 * @param caseHexa La case
	 * @param orientation L'orientation
	 */
	// A n'utiliser qu'à l'initialisation du plateau
	public void setCaseHexa(CaseHexa caseHexa, int orientation)
	{
		this.caseHexa = caseHexa;
		this.dir = orientation;
	}

	/**
	 * Fait tourner le robot à gauche ou à droite
	 *
	 * @param direction gauche ou droite
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
	 * Fait avancer le robot, en poussant un cristal ou un robot si il gêne, si possible.
	 * Ne peut faire sortir aucun objet du plateau
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
	 * Charge un cristal si il y en a un devant
	 * ou si un robot porte un cristal devant(le 2e robot perd son cristal).
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
	 * Sets les ordres du robot pour le mode test
	 *
	 * @param tabTest les nouveaux ordres
	 */
	public void setTestOrdres(String tabTest)
	{
		tabOrdres = tabTest.split(":");
		this.action();
	}

	/**
	 * Dépose un cristal sur la case en face, sur un robot ne portant pas de cristal,
	 * ou dans une base (alliée ou adverse)
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
