import java.io.*;
import java.util.*;
public class Plateau {
	private int nbCases;
	private int pointMax;

	private CaseHexa[] terrain;
	private Joueur[]   tabJoueur;
	private int tourJoueur;
	private int typePlateau;

	public Plateau(String[] nomJoueur)
	{
		this.nbCases = 61;
		this.typePlateau = 1;
		this.tabJoueur = new Joueur[nomJoueur.length];

		for (int i = 0 ; i< nomJoueur.length ;i++ )
		{
			this.tabJoueur[i] = new Joueur(nomJoueur[i]);
		}
		pointMax = 13-nomJoueur.length;
		this.terrain = setTerrain(nomJoueur.length);
		tourJoueur = 0;
	}

	public void changerJoueur()
	{
		tourJoueur=(tourJoueur+1)%tabJoueur.length;
	}

	public Joueur getJoueurCourant()
	{
		return tabJoueur[tourJoueur];
	}

	public boolean getVictoire()
	{
		for (Joueur j : tabJoueur )
		{
			if (j.getPoint() >= pointMax)
				return true;

		}
		return false;
	}

	private CaseHexa[] setTerrain(int nbJoueur)
	{
		if (nbJoueur>4) { this.nbCases=91; this.typePlateau = 2; }
		CaseHexa[] voisinsHexa;
		CaseHexa[] retour = new CaseHexa[nbCases];
		String[] contenu  = new String  [nbCases];
		String[] voisins  = new String  [nbCases];
		int cpt = 0;
		Robot tmp;
		Base base;

		final File fichier =new File("Data/Plateau"+nbJoueur+".data");
		try
		{
			Scanner sc = new Scanner (new FileReader( fichier) );

			while ( sc.hasNext() )
			{
				String[] infocase = sc.nextLine().split("/");
				retour[cpt] = new CaseHexa(infocase[0]);
				voisins[cpt] = infocase[1];
				contenu[cpt] = infocase[0];
				cpt ++;
			}
		}
		catch (Exception e) {
			System.out.println("Impossible de cr\u00e9er le plateau");
		}
		for (int i = 0;i< nbCases;i++ )
		{
			voisinsHexa = new CaseHexa[6];
			String[] splitVoisins = voisins[i].split("-");
			for (int j = 0;j< voisinsHexa.length;j++)
			{
				if (!splitVoisins[j].equals("R"))
				{
					voisinsHexa[j] = retour[Integer.parseInt(splitVoisins[j])];
				}
			}
			retour[i].setVoisins(voisinsHexa);
		}

		for (int k = 0;k< nbCases;k++ )
		{
			String[] splitContenu = contenu[k].split("-");

			for (int l = 0;l< splitContenu.length;l++)
			{
				if (!splitContenu[0].equals("N"))
				{
					if (splitContenu[0].equals("R"))
					{
						tmp = new Robot();
						//TODO: setCaseHexa !!
						retour[k].setContenu(tmp);
						this.tabJoueur[Integer.parseInt(splitContenu[1])].setRobot(tmp,retour[k],Integer.parseInt(splitContenu[2]));
					}

					if (splitContenu[0].equals("C"))
					{
						retour[k].setContenu(Cristal.creerCristal(Integer.parseInt(splitContenu[1])));
					}

					if (splitContenu[0].equals("B"))
					{
						base = new Base();
						retour[k].setContenu(base);
						this.tabJoueur[Integer.parseInt(splitContenu[1])].setBase(base);
					}
				}
			}
		}


		return retour;
	}

	public String afficherPlateau(){
		String retour = "";

		int i = 0;
		final File fichier =new File("Data/AffichagePlateau"+this.typePlateau+".data");
		try {
			Scanner sc = new Scanner (fichier );

			while ( sc.hasNext() )
			{
				String s =  sc.next();
				if (s.equals("$")) {retour += " "+this.terrain[i++].getid()+" ";}
				else             {retour += s;}
			}
			retour = retour.replaceAll(	"3", "\n");
			retour = retour.replaceAll(	"1", " ");
			retour = retour.replaceAll(	"4", "    ");
		} catch (Exception e) {
		}
		return retour;
	}
}
