import java.util.ArrayList;
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
	private int[] mainNbOrdres;
	private int[] mainNbOrdresStock;

	public Joueur(String nom)
	{
		this.nom = nom;
		this.points = 0;
		this.robots = new Robot[2];

		mainNbOrdres      = new int[] {2,1,3,3,2,2};
		mainNbOrdresStock = new int[] {2,1,3,3,2,2};

		//TODO : type de robot ?????
	}

	public int getDirRobot(int numRobot)
	{
		return robots[numRobot].getDir();
	}

	public boolean robotAppartientAuJoueur(Robot robot)
	{
		for(int i=0; i<robots.length; i++)
			if(robots[i].equals(robot))
				return true;

		return false;
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

	public String[] getOrdresRobot(int numRobot)
	{
		return robots[numRobot].getOrdres();
	}

	public int getPoints()
	{
		int pointsTot;

		pointsTot = this.points+this.robots[0].getValeurCristal()+this.robots[1].getValeurCristal();

		return pointsTot;
	}

	public ArrayList<Cristal> getCristauxBase()
	{
		return this.baseJoueur.getCristaux();
	}

	public int getNbCristaux(int valeur)
	{
		return this.baseJoueur.getNbCristaux(valeur);
	}

	public int comparerPoints(boolean etape, Joueur autreJoueur)
	{
		return (etape)? this.getPoints()-autreJoueur.getPoints() : this.getPoint()-autreJoueur.getPoint();
	}

	public void resetCarte()
	{
		for(int cpt=0; cpt<mainNbOrdres.length; cpt++)
				mainNbOrdres[cpt] = mainNbOrdresStock[cpt];
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
	public void setTestOrdres(String orde,int numRobot){
		robots[numRobot].setTestOrdres(orde);
	
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
