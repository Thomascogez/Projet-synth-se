import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * Classe Joueur.
 *
 * @author Quentin BERNARDIN
 * @author Mathieu BOIREAU
 * @author Thomas  COGEZ--ALLIX
 * @author Patrice MAISONNEUVE
 * @version 06-21-2019
 */

public class Joueur
{
	
	/** The nom. */
	private String  nom;
	
	/** The base joueur. */
	private Base    baseJoueur;
	
	/** The points. */
	private int     points;
	
	/** The robots. */
	private Robot[] robots;

	/** The Constant mainOrdres. */
	private static final String[] mainOrdres = new String[] {"Avancer", "Avancer2",
	                                                         "TournerG", "TournerD",
	                                                         "Charger", "Deposer"   };
	
	/** The main nb ordres. */
	private int[] mainNbOrdres;
	
	/** The main nb ordres stock. */
	private int[] mainNbOrdresStock;

	/**
	 * Instantiates a new joueur.
	 *
	 * @param nom the nom
	 */
	public Joueur(String nom)
	{
		this.nom = nom;
		this.points = 0;
		this.robots = new Robot[2];

		mainNbOrdres      = new int[] {2,1,3,3,2,2};
		mainNbOrdresStock = new int[] {2,1,3,3,2,2};

		//TODO : type de robot ?????
	}

	/**
	 * Gets the dir robot.
	 *
	 * @param numRobot the num robot
	 * @return the dir robot
	 */
	public int getDirRobot(int numRobot)
	{
		return robots[numRobot].getDir();
	}

	/**
	 * Gets the robots.
	 *
	 * @return the robots
	 */
	public Robot[] getRobots(){
		return robots;
	}

	/**
	 * Robot appartient au joueur.
	 *
	 * @param robot the robot
	 * @return true, if successful
	 */
	public boolean robotAppartientAuJoueur(Robot robot)
	{
		for(int i=0; i<robots.length; i++)
			if(robots[i].equals(robot))
				return true;

		return false;
	}

	/**
	 * Gets the main ordres.
	 *
	 * @return the main ordres
	 */
	public String[] getMainOrdres()
	{
		return mainOrdres;
	}

	/**
	 * Gets the main nb ordres.
	 *
	 * @return the main nb ordres
	 */
	public int[] getMainNbOrdres()
	{
		return mainNbOrdres;
	}

	/**
	 * Donner ordres.
	 *
	 * @param numRobot the num robot
	 */
	public void donnerOrdres(int numRobot)
	{
		robots[numRobot].action();
	}

	/**
	 * Donner ordres modif.
	 *
	 * @param tabOrdres the tab ordres
	 * @param numRobot the num robot
	 * @return true, if successful
	 */
	public boolean donnerOrdresModif(String[] tabOrdres, int numRobot)
	{
		resetCarte();

		int numAutreRobot;
		if(numRobot == 0)
			numAutreRobot = 1;
		else
			numAutreRobot = 0;
		String[] tabAutre = robots[numAutreRobot].getOrdres();

		for(int i=0; i<tabOrdres.length; i++)
		{
			for(int j=0; j<mainOrdres.length; j++)
			{
				if(tabOrdres[i]!=null)
				{
					if( tabOrdres[i].equals(mainOrdres[j]) ||
					    tabAutre[i].equals(mainOrdres[j])   )
					{
						if(mainNbOrdres[j]>0)
							mainNbOrdres[j]--;
						else
							return false;
					}
				}
			}
		}
		robots[numRobot].actionModif(tabOrdres);
		return true;
	}

	/**
	 * Actualiser main.
	 */
	public void actualiserMain()
	{
		resetCarte();

		String[] tabOrdres = robots[0].getOrdres();
		String[] tabAutre  = robots[1].getOrdres();

		for(int i=0; i<tabOrdres.length; i++)
		{
			for(int j=0; j<mainOrdres.length; j++)
			{
				if(tabOrdres[i]!=null)
				{
					if(tabOrdres[i].equalsIgnoreCase(mainOrdres[j]))
						if(mainNbOrdres[j]>0)
							mainNbOrdres[j]--;
					if(tabAutre[i].equalsIgnoreCase(mainOrdres[j]))
						if(mainNbOrdres[j]>0)
							mainNbOrdres[j]--;
				}
			}
		}
	}

	/**
	 * Gets the ordres robot.
	 *
	 * @param numRobot the num robot
	 * @return the ordres robot
	 */
	public String[] getOrdresRobot(int numRobot)
	{
		return robots[numRobot].getOrdres();
	}

	/**
	 * Gets the points.
	 *
	 * @return the points
	 */
	public int getPoints()
	{
		int pointsTot;

		pointsTot = this.points+this.robots[0].getValeurCristal()+this.robots[1].getValeurCristal();

		return pointsTot;
	}

	/**
	 * Gets the cristaux base.
	 *
	 * @return the cristaux base
	 */
	public ArrayList<Cristal> getCristauxBase()
	{
		return this.baseJoueur.getCristaux();
	}

	/**
	 * Gets the nb cristaux.
	 *
	 * @param valeur the valeur
	 * @return the nb cristaux
	 */
	public int getNbCristaux(int valeur)
	{
		return this.baseJoueur.getNbCristaux(valeur);
	}

	/**
	 * Comparer points.
	 *
	 * @param etape the etape
	 * @param autreJoueur the autre joueur
	 * @return the int
	 */
	public int comparerPoints(boolean etape, Joueur autreJoueur)
	{
		return (etape)? this.getPoints()-autreJoueur.getPoints() : this.getPoint()-autreJoueur.getPoint();
	}

	/**
	 * Reset carte.
	 */
	public void resetCarte()
	{
		for(int cpt=0; cpt<mainNbOrdres.length; cpt++)
				mainNbOrdres[cpt] = mainNbOrdresStock[cpt];
	}

	/**
	 * Ajouter cristal.
	 *
	 * @param c the c
	 */
	public void ajouterCristal(Cristal c){
		this.baseJoueur.ajouterCristal(c);
	}

	/**
	 * Sets the robot.
	 *
	 * @param r the r
	 * @param caseHex the case hex
	 * @param orientation the orientation
	 */
	public void setRobot(Robot r, CaseHexa caseHex, int orientation)
	{
		if (robots[0] == null)
		{
			robots[0]=r;
			this.setCaseHexa(robots[0], caseHex, orientation);
			return;
		}
		robots[1]=r;
		this.setCaseHexa(robots[1], caseHex, orientation);
	}
	
	/**
	 * Sets the test ordres.
	 *
	 * @param orde the orde
	 * @param numRobot the num robot
	 */
	public void setTestOrdres(String orde,int numRobot){
		robots[numRobot].setTestOrdres(orde);

	}
	
	/**
	 * Gets the cristal robot.
	 *
	 * @param id the id
	 * @return the cristal robot
	 */
	public int getCristalRobot(int id)
	{
		int val = 0;
		if(id == 0 || id == 1)
			val = robots[0].getValeurCristal()+1;
		return val;
	}

	/**
	 * Sets the base.
	 *
	 * @param b the new base
	 */
	public void setBase(Base b)
	{
		this.baseJoueur=b;
	}

	/**
	 * Sets the case hexa.
	 *
	 * @param r the r
	 * @param caseHex the case hex
	 * @param orientation the orientation
	 */
	public void setCaseHexa(Robot r, CaseHexa caseHex, int orientation)
	{
		r.setCaseHexa(caseHex, orientation);
	}

	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Gets the point.
	 *
	 * @return the point
	 */
	public int getPoint() {
		return points;
	}

	/**
	 * Sets the point.
	 *
	 * @param point the new point
	 */
	public void setPoint(int point){
		this.points += point;
	}
}
