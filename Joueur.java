/**
 * Joueur
 */
public class Joueur
{
	private String  nom;
	private Base    baseJoueur;
	private int     points;
	private Robot[] robots;

	private static final String[] mainOrdres = new String[] {"Avancer", "Avancer2",
	                                                         "TournerG", "TournerD",
	                                                         "Charger", "Deposer"   };
	private int[]    mainNbOrdres;

	public Joueur(String nom)
	{
		this.nom = nom;
		this.baseJoueur = new Base();
		this.points = 0;
		this.robots = new Robot[2];

		mainNbOrdres = new int[] {2,1,3,3,2,2};

		//TODO : type de robot ?????
		this.initRobot();
	}

	public String[] getMainOrdres()
	{
		return mainOrdres;
	}

	public int[] getMainNbOrdres()
	{
		return mainNbOrdres;
	}

	public void donnerOrdres(int numRobot)
	{
		robots[numRobot].action();
	}

	public boolean donnerOrdresModif(String[] tabOrdres, int numRobot)
	{
		for(int i=0; i<tabOrdres.length; i++)
		{
			for(int j=0; j<mainOrdres.length; j++)
			{
				if( tabOrdres[i].equals(mainOrdres[j]) )
				{
					if(mainNbOrdres[j]>0)
						mainNbOrdres[j]--;
					else
						return false;
				}
			}
		}
		robots[numRobot].actionModif(tabOrdres);
		return true;
	}

	private void initRobot(){
		robots[0] = new Robot();
		robots[1] = new Robot();
	}

	public void ajouterCristal(Cristal c){
		this.baseJoueur.ajouterCristal(c);
	}

	public String getNom() {
		return nom;
	}

	public int getPoint() {
		return points;
	}

	public void setPoint(int point){
		this.points += point;
	}
}