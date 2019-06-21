import java.io.*;
import java.util.*;

/**
 * Classe Plateau
 * @author Quentin BERNARDIN
 * @author Mathieu BOIREAU
 * @author Thomas  COGEZ--ALLIX
 * @author Patrice MAISONNEUVE
 * @version 06-21-2019
 */

public class Plateau
{
	private int nbCases;
	private int pointMax;

	private CaseHexa[] terrain;
	private Joueur[]   tabJoueur;
	private int tourJoueur;
	private int typePlateau;
	private Stack<Cristal> pileCristaux;
	private int longueurMin;
	private int longueurMax;
	private int dernierTour;

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

	public void changerJoueur(){tourJoueur=(tourJoueur+1)%tabJoueur.length;}
	public Joueur getJoueurCourant(){return tabJoueur[tourJoueur];}
	public int getJoueur(){return tourJoueur;}

	public boolean getVictoirePoint()
	{
		for (Joueur j : tabJoueur )
		{
			if (j.getPoint() >= pointMax)
				return true;
		}
		return false;
	}
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
	public Joueur getMeileurJoueur(){
		int pointMax = 0;
		Joueur j = this.tabJoueur[0];
		for (int i = 0; i<this.tabJoueur.length;i++ ) {
			int point = this.tabJoueur[i].getPoint();
			for (Robot r : this.tabJoueur[i].getRobots()) {
				point += r.getValeurCristal();
			}
			if (point>pointMax) {
				pointMax = point;
				j =  this.tabJoueur[i];
			}
		}
		return j;

	}

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
							robot = new Robot(this);
							terrain[tabObjContenu[2]].setContenu(robot);
							tabJoueur[tabObjContenu[0]].setRobot(robot,
							                                     terrain[tabObjContenu[2]],
							                                     tabObjContenu[1]);
						}

						if(cpt==1)
						{
							base = new Base();
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

	public Joueur getJoueur(int id){
		return tabJoueur[id];
	}

	public void ajouterNouvCristalDePile(int indCase)
	{
		if(terrain[indCase].getContenu()==null)
			terrain[indCase].setContenu(pileCristaux.pop());

		else
		{
			CaseHexa[] casesVoisines = terrain[indCase].getVoisines();
			for(int i=0; i<6; i++)
			{
				if(casesVoisines[i].getContenu() == null)
				{
					casesVoisines[i].setContenu(pileCristaux.pop());
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
						casesVoisinesDeVoisine[j].setContenu(pileCristaux.pop());
			}
		}
	}

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
					if(this.terrain[caseHex].getid().equals("R") &&
					   !getJoueurCourant().robotAppartientAuJoueur((Robot)(terrain[caseHex].getContenu())) )
						retour += " r ";
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
