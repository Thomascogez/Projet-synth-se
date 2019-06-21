import java.io.*;
import java.util.*;

/**
 * Classe Plateau.
 *
 * @author Quentin BERNARDIN
 * @author Mathieu BOIREAU
 * @author Thomas  COGEZ--ALLIX
 * @author Patrice MAISONNEUVE
 * @version 06-21-2019
 */

public class Plateau
{

	/** Le nombre de cases. */
	private int nbCases;

	/** Le nombre de point max. */
	private int pointMax;

	/** Le terrain. */
	private CaseHexa[] terrain;

	/** Le tab joueur. */
	private Joueur[]   tabJoueur;

	/** Le numéro du joueur. */
	private int tourJoueur;

	/** Le type du plateau (si typePlateau = 1, 61cases - si typePlateau = 2, 91cases). */
	private int typePlateau;

	/** La pile de cristaux. */
	private Stack<Cristal> pileCristaux;

	/** La longueur min. d'une ligne*/
	private int longueurMin;

	/** La longueur max. d'une ligne*/
	private int longueurMax;

	/** Le dernier tour. */
	private int dernierTour;

	/**
	 * Instancie un nouveau plateau.
	 *
	 * @param nomJoueur Le tableau contenant les noms des joueurs dans l'ordre
	 */
	public Plateau(String[] nomJoueur)
	{
		this.nbCases = 61;
		this.typePlateau = 1;
		this.dernierTour = 3;
		this.tabJoueur = new Joueur[nomJoueur.length];
		longueurMin = 5;
		longueurMax = 9;

		for (int i = 0 ; i< nomJoueur.length ;i++ )
		{
			this.tabJoueur[i] = new Joueur(nomJoueur[i]);
		}
		pointMax = 13-nomJoueur.length;
		pileCristaux = new Stack<Cristal>();
		this.terrain = creerTerrain(nomJoueur.length);
		initTerrain(nomJoueur.length);

		tourJoueur = 0;
	}

	/**
	 * Passe au joueur suivant.
	 */
	public void changerJoueur(){
		tabJoueur[tourJoueur].setPoint();
		tourJoueur=(tourJoueur+1)%tabJoueur.length;
	}

	/**
	 * Renvoie le joueur courant.
	 *
	 * @return le joueur courant
	 */
	public Joueur getJoueurCourant(){return tabJoueur[tourJoueur];}

	/**
	 * Renvoie une chaine d'affichage des ordres des robots qui ne jouent pas
	 *
	 * @return chaine à afficher
	 */
	public String afficherRobotsJouentPas()
	{
		String retour="Robots des autres joueurs\n";

		for(int i=0; i<tabJoueur.length; i++)
		{
			if(i!=tourJoueur)
			{
				retour += "\tJoueur "+(i+1)+"\n\t\t| ";
				Robot[] robot = tabJoueur[i].getRobots();
				for(int j=0; j<2; j++)
				{
					retour += "Robot "+(j+1)+" : ";
					String[] ordres = robot[j].getOrdres();
					for(int cpt=0; cpt<3; cpt++)
						retour += ordres[cpt]+" - ";

					retour += "(Dir:";
					if(robot[j].getDir()==0)
						retour+="H";
					if(robot[j].getDir()==1)
						retour+="HD";
					if(robot[j].getDir()==2)
						retour+="BD";
					if(robot[j].getDir()==3)
						retour+="B";
					if(robot[j].getDir()==4)
						retour+="BG";
					if(robot[j].getDir()==5)
						retour+="HG";
					retour+=") | ";
				}
				retour += "\n";
			}
		}
		return retour;
	}

	/**
	 * Methode retournant la pile de cristaux
	 * 
	 * @return pileCristaux
	 */
	public Stack<Cristal> getPileCristaux(){
		return pileCristaux;
	}

	/**
	 * Renvoie le numéro de joueur.
	 *
	 * @return le numéro de joueur
	 */
	public int getJoueur(){return tourJoueur;}

	/**
	 * Renvoie vrai si un joueur a atteint de nombre de points pour gagner
	 *
	 * @return si un joueur a atteint de nombre de points pour gagner
	 */
	public boolean getVictoirePoint()
	{
		for (Joueur j : tabJoueur )
		{
			if (j.getPoint() >= pointMax)
				return true;
		}
		return false;
	}

	/**
	 * Renvoie faux quand la partie est finie
	 *
	 * @return si la partie n'est pas finie
	 */
	public boolean getVictoireCrystal()
	{
		if (pileCristaux.size()==0) {
			this.dernierTour--;
			if (this.dernierTour==0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Renvoie le joueur avec le meilleur score
	 *
	 * @return le meilleur joueur
	 */
	public Joueur getMeileurJoueur(){
		int pointMax = 0;
		Joueur j = this.tabJoueur[0];
		for (int i = 0; i<this.tabJoueur.length;i++ ) {
			int point = this.tabJoueur[i].getPoint();
			for (Robot r : this.tabJoueur[i].getRobots()) {
				point += r.getValeurCristal()-1;
			}
			if (point>pointMax) {
				pointMax = point;
				j =  this.tabJoueur[i];
			}
		}
		return j;

	}

	/**
	 * Créer le terrain.
	 *
	 * @param nbJoueur Le nombre de joueurs
	 * @return le terrain sous la forme d'un tableau de cases hexagonales
	 */
	public CaseHexa[] creerTerrain(int nbJoueur)
	{
		if (nbJoueur>4)
		{
			this.nbCases=91;
			this.typePlateau = 2;
		}
		int longueurCourante = this.longueurMin;
		CaseHexa[] terrain = new CaseHexa[91];
		int cpt = 0;
		int caseHex = 0;
		int longueurTot = longueurCourante;

		for (int i = 0;i<nbCases ;i++ )
			terrain[i] = new CaseHexa();

		while(cpt <4)
		{
			while(caseHex<longueurTot && longueurCourante<=this.longueurMax)
			{
				if (terrain[caseHex]!=terrain[longueurTot-1])
					terrain[caseHex].lierCase(terrain[caseHex+1],0);

				terrain[caseHex].lierCase(terrain[caseHex+longueurCourante],2);
				terrain[caseHex].lierCase(terrain[caseHex+longueurCourante+1], 1);
				caseHex++;
			}
			longueurCourante++;
			longueurTot+= longueurCourante;
			cpt++;
		}

		while(cpt >=0)
		{
			while(caseHex<longueurTot && longueurCourante>=this.longueurMin)
			{
				if (terrain[caseHex]!=terrain[longueurTot-1] && cpt != 0)
				{
					terrain[caseHex].lierCase(terrain[caseHex+1], 0);
					terrain[caseHex].lierCase(terrain[caseHex+longueurCourante], 1);
				}

				if (terrain[caseHex]!=terrain[longueurTot-longueurCourante] && cpt != 0)
					terrain[caseHex].lierCase(terrain[caseHex+longueurCourante-1], 2);

				if (cpt == 0 && terrain[caseHex]!=terrain[longueurTot-1])
					terrain[caseHex].lierCase(terrain[caseHex+1], 0);

				caseHex++;
			}
			longueurCourante--;
			longueurTot+= longueurCourante;
			cpt--;
		}

		return terrain;
	}

	/**
	 * Initialise le terrain.
	 *
	 * @param nbJoueur Le nombre de joueurs
	 */
	private void initTerrain(int nbJoueur)
	{
		final File fichier =new File("Data/Plateau.data");
		String sTmp;
		try{
			Scanner sc = new Scanner (new FileReader( fichier) );

			while ( sc.hasNext() )
			{
				sTmp = sc.nextLine();
				if(sTmp.equals("Plateau "+nbJoueur+" :"))
					break;
			}

			String[] tabObjets;
			String[] tabStrObjContenu;
			Robot    robot;
			Base     base;
			Cristal  cristal;
			for(int cpt=0; cpt<4; cpt++)
			{
				sTmp = sc.nextLine();
				tabObjets = sTmp.split("/");
				for(int i=0; i<tabObjets.length; i++)
				{
					tabStrObjContenu = tabObjets[i].split("-");
					int[] tabObjContenu = new int[tabStrObjContenu.length];
					for(int j=0; j<tabStrObjContenu.length; j++)
						tabObjContenu[j] = Integer.parseInt(tabStrObjContenu[j]);

					for(int j=0; j<tabObjContenu.length; j++)
					{
						if(cpt==0)
						{
							robot = new Robot(this, tabObjContenu[0]);
							terrain[tabObjContenu[2]].setContenu(robot);
							tabJoueur[tabObjContenu[0]].setRobot(robot,
							                                     terrain[tabObjContenu[2]],
							                                     tabObjContenu[1]);
						}

						if(cpt==1)
						{
							base = new Base(tabObjContenu[0]);
							terrain[tabObjContenu[1]].setContenu(base);
							tabJoueur[tabObjContenu[0]].setBase(base);
						}

						if(cpt==2)
						{
							cristal = Cristal.creerCristal(tabObjContenu[0]);
							terrain[tabObjContenu[1]].setContenu(cristal);
							cristal.setPositionDeBase(tabObjContenu[1]);
						}

						if(cpt==3)
						{
							cristal = Cristal.creerCristal(tabObjContenu[0]);
							pileCristaux.push(cristal);
						}
					}
				}
			}
		}catch(Exception e){e.printStackTrace();/*System.out.println("Impossible d'initialiser le plateau !");*/}
	}

	/**
	 * Renvoie le joueur dont le numéro est donné en paramètre.
	 *
	 * @param id l'indice du joueur dans le tableau de joueurs
	 * @return le joueur
	 */
	public Joueur getJoueur(int id){
		return tabJoueur[id];
	}


	/**
	 * Retire un cristal de la pile et le place le plus proche possible de la case
	 * dont le numéro est donné en paramètre
	 *
	 * @param indCase L'indice de la case
	 */
	public void ajouterNouvCristalDePile(int indCase)
	{
		if(terrain[indCase].getContenu()==null)
			if(pileCristaux.size() > 0)
			{
				terrain[indCase].setContenu(pileCristaux.pop());
			}
			
		else
		{
			CaseHexa[] casesVoisines = terrain[indCase].getVoisines();
			for(int i=0; i<6; i++)
			{
				if(casesVoisines[i].getContenu() == null)
				{
					if(pileCristaux.size() > 0)
					{
						casesVoisines[i].setContenu(pileCristaux.pop());
					}
					return;
				}
			}

			// Si il n'y a de la place ni sur la case, ni sur les cases voisines,
			// on regarde les voisines des voisines. Cela ne rend pas un problème
			// impossible mais totalement improbable.
			for(int i=0; i<6; i++)
			{
				CaseHexa[] casesVoisinesDeVoisine = casesVoisines[i].getVoisines();
				for(int j=0; j<6; j++)
					if(casesVoisinesDeVoisine[j].getContenu() == null)
						if(pileCristaux.size() > 0)
						{
							casesVoisinesDeVoisine[j].setContenu(pileCristaux.pop());
						}
			}
		}
	}

	/**
	 * Renvoie le plateau sous la forme d'une chaine
	 *
	 * @return le plateau
	 */
	public String afficherPlateau(){
		String retour = "";
		int caseHex;

		final File fichier =new File("Data/AffichagePlateau"+typePlateau+".data");
		try {
			Scanner sc = new Scanner (fichier );

			while ( sc.hasNext() )
			{
				String s =  sc.next();
				if (s.contains("$"))
				{
					caseHex = Integer.parseInt(s.substring(s.trim().lastIndexOf("$")+1));
					if(this.terrain[caseHex].getid().equals("R"))
					{
						Robot robot = (Robot)(this.terrain[caseHex].getContenu());
						retour +=robot.getNumJoueur()+this.terrain[caseHex].getid()+" ";
					}
					else if(this.terrain[caseHex].getid().equals("C"))
					{
						Cristal cristal = (Cristal)(this.terrain[caseHex].getContenu());
						retour += " "+this.terrain[caseHex].getid()+cristal.getValeur();
					}
					else if(this.terrain[caseHex].getid().equals("B"))
					{
						Base base = (Base)(this.terrain[caseHex].getContenu());
						retour += base.getNumJoueur()+this.terrain[caseHex].getid()+" ";
					}
					else
						retour += " "+this.terrain[caseHex].getid()+" ";
				}
				else
				{
					retour += s;
				}
			}
			retour = retour.replaceAll(	"l", "\n");
			retour = retour.replaceAll(	"e", " ");
			retour = retour.replaceAll(	"t", "    ");
		} catch (Exception e) {}
		return retour;
	}
}
