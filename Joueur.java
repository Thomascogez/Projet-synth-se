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
		this.points = 0;
		this.robots = new Robot[2];

		mainNbOrdres = new int[] {2,1,3,3,2,2};

		//TODO : type de robot ?????
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

	public void ajouterCristal(Cristal c){
		this.baseJoueur.ajouterCristal(c);
	}

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

	public void setBase(Base b)
	{
		this.baseJoueur=b;
	}

	public void setCaseHexa(Robot r, CaseHexa caseHex, int orientation)
	{
		r.setCaseHexa(caseHex, orientation);
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
