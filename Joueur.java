import java.util.ArrayList;
import java.util.Arrays;

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
	
	/** Le nom du joueur. */
	private String  nom;
	
	/** La base du joueur. */
	private Base    baseJoueur;
	
	/** Les points du joueurs. */
	private int     points;
	
	/** Les robots du joueur. */
	private Robot[] robots;

	/** Les noms des ordres en main constants */
	private static final String[] mainOrdres = new String[] {"Avancer", "Avancer2",
	                                                         "TournerG", "TournerD",
	                                                         "Charger", "Deposer"   };
	
	/** Le nombre de chaque ordre en main. */
	private int[] mainNbOrdres;
	
	/** 
	 * Le nombre de chaque ordre en main en début de partie
	 * (pour réinitialiser la main du joueur)
	 */
	private int[] mainNbOrdresStock;

	/**
	 * Instancie un nouveau joueur.
	 *
	 * @param nom Le nom du joueur
	 */
	public Joueur(String nom)
	{
		this.nom = nom;
		this.points = 0;
		this.robots = new Robot[2];

		mainNbOrdres      = new int[] {2,1,3,3,2,2};
		mainNbOrdresStock = new int[] {2,1,3,3,2,2};
	}

	/**
	 * Renvoie la direction robot.
	 *
	 * @param numRobot Le numéro du robot
	 * @return la direction du robot
	 */
	public int getDirRobot(int numRobot)
	{
		return robots[numRobot].getDir();
	}

	/**
	 * Renvoie une copie du tableau de robots du joueur
	 *
	 * @return le tableau de robots
	 */
	public Robot[] getRobots(){
		return Arrays.copyOf(robots, robots.length);
	}

	/**
	 * Renvoie une copie du tableau des noms des ordres en main
	 *
	 * @return les noms des ordres en main
	 */
	public String[] getMainOrdres()
	{
		return Arrays.copyOf(mainOrdres, mainOrdres.length);
	}

	/**
	 * Renvoie une copie du tableau des noms des ordres en main	 *
	 * @return le nombre des ordres en main
	 */
	public int[] getMainNbOrdres()
	{
		return Arrays.copyOf(mainNbOrdres, mainNbOrdres.length);
	}

	/**
	 * Donne les ordres au robot.
	 *
	 * @param numRobot Le numéro du robot
	 */
	public void donnerOrdres(int numRobot)
	{
		robots[numRobot].action();
	}

	/**
	 * Donner les modifications aux ordres.
	 *
	 * @param tabOrdres Le tableau des ordres à donner
	 * @param numRobot Le numéro du robot
	 * @return vrai si le joueur a suffisamment d'ordres en main pour faire l'action
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
	 * Actualise la quantité d'ordre dans la main du joueur.
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
	 * Renvoie les ordres du robot.
	 *
	 * @param numRobot Le numéro du robot
	 * @return les noms des ordres du robot
	 */
	public String[] getOrdresRobot(int numRobot)
	{
		return robots[numRobot].getOrdres();
	}

	/**
	 * Renvoie les points du joueur.
	 *
	 * @return les points
	 */
	public int getPoints()
	{
		int pointsTot;

		pointsTot = this.points+this.robots[0].getValeurCristal()+this.robots[1].getValeurCristal();

		return pointsTot;
	}

	/**
	 * Renvoie la liste des cristaux dans la base du joueur.
	 *
	 * @return les cristaux de la base
	 */
	public ArrayList<Cristal> getCristauxBase()
	{
		return this.baseJoueur.getCristaux();
	}

	/**
	 * Renvoie le nombre de cristaux de la valeur voulue.
	 *
	 * @param valeur la valeur
	 * @return le nombre de cristaux
	 */
	public int getNbCristaux(int valeur)
	{
		return this.baseJoueur.getNbCristaux(valeur);
	}

	/**
	 * Réinitialise les ordres en main.
	 */
	public void resetCarte()
	{
		for(int cpt=0; cpt<mainNbOrdres.length; cpt++)
				mainNbOrdres[cpt] = mainNbOrdresStock[cpt];
	}

	/**
	 * Ajouter un cristal dans la base.
	 *
	 * @param c Le cristal à ajouter
	 */
	public void ajouterCristal(Cristal c){
		this.baseJoueur.ajouterCristal(c);
	}

	/**
	 * Sets le robot.
	 *
	 * @param r Le robot
	 * @param caseHex La case du robot
	 * @param orientation L'orientation du robot
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
	 * Sets des ordres pour le mode de test.
	 *
	 * @param ordre les ordes
	 * @param numRobot le numéro robot
	 */
	public void setTestOrdres(String ordre,int numRobot)
	{
		robots[numRobot].setTestOrdres(ordre);
	}
	
	/**
	 * Renvoie le cristal tenu par le robot.
	 *
	 * @param id L'id du robot
	 * @return la valeur du cristal porté par le robot (peut être nul s'il n'en porte pas)
	 */
	public int getCristalRobot(int id)
	{
		int val = 0;
		if(id == 0 || id == 1)
			val = robots[0].getValeurCristal();
		return val;
	}

	/**
	 * Sets la base.
	 *
	 * @param b La base
	 */
	public void setBase(Base b)
	{
		this.baseJoueur=b;
	}

	/**
	 * Sets la case du robot au robot.
	 *
	 * @param r Le robot
	 * @param caseHex La case
	 * @param orientation L'orientation
	 */
	public void setCaseHexa(Robot r, CaseHexa caseHex, int orientation)
	{
		r.setCaseHexa(caseHex, orientation);
	}

	/**
	 * Gets le nom.
	 *
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Renvoie le nombre de points.
	 *
	 * @return les points
	 */
	public int getPoint() {
		return points;
	}

	/**
	 * Ajoute des points
	 *
	 * @param point Les points à ajouter
	 */
	public void setPoint(int point){
		this.points += point;
	}
}
