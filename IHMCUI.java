import java.util.ArrayList;
import java.util.Scanner;

import iut.algo.*;
public class IHMCUI
{

	public void ecranDemarrage()
	{
		System.out.println(
		        "  _   _   _   _     _   _   _     _   _   _   _  \r\n / \\ / \\ / \\ / \\   / \\ / \\ / \\   / \\ / \\ / \\ / \\ \r\n( T | w | i | n ) ( T | i | n ) ( B | o | t | s )\r\n \\_/ \\_/ \\_/ \\_/   \\_/ \\_/ \\_/   \\_/ \\_/ \\_/ \\_/ ");
	}

	public String[] nouvellePartie()
	{
		//Initialisation : on demande le nombre de joueurs, avec vérification...
		System.out.print ( "Choix du nombre de joueurs [2..6] : " );
		int nbJoueurMax = Clavier.lire_int();

		while (nbJoueurMax>6||nbJoueurMax<2)
		{
			Console.println ( CouleurConsole.ROUGE.getFont()+"ERREUR : Choix du nombre de joueurs invalide !" );
			Console.normal();
			Console.print ( "Choix du nombre de joueurs [2..6] : " );
			nbJoueurMax = Clavier.lire_int();
		}
		//...Et on demande leurs noms respectifs
		String[] tabNom = new String[nbJoueurMax];
		for (int i= 0; i< nbJoueurMax ;i++ )
		{
			Console.print (CouleurConsole.CYAN.getFont()+"Nom du Joueur " +(i+1)+ " : ");
			Console.normal();
			tabNom[i] = Clavier.lireString();
		}
		return tabNom;
	}

	public void afficherGrille(String grille, Joueur joueur)
	{
		System.out.println(grille);
		System.out.println("Tour du Joueur " + joueur.getNom());
	}
	public void afficherScores(ArrayList<Joueur> lJoueur)
	{
		System.out.println("+------------+-----------+");
		System.out.println("|      Joueur|      Score|");
		System.out.println("+------------+-----------+");
		for (Joueur j : lJoueur)
			Console.println(String.format("|"+CouleurConsole.VERT.getFont()+" %10s"+CouleurConsole.JAUNE.getFont()+" | "+CouleurConsole.JAUNE.getFont()+"%3d points"+CouleurConsole.BLANC.getFont()+"|", j.getNom(), j.getPoint()));

		Console.normal();
		System.out.println("+------------+-----------+");

	}
	public String menuAction() {
		Console.println("\tVoulez-vous modifier un programme avant execution ? : \n\n" +
		                "\t\t"+ CouleurConsole.VERT.getFont()  +" 1 - Oui\n"           +
		                "\t\t"+ CouleurConsole.ROUGE.getFont() +" 2 - Non"              );
		Console.normal();
		Scanner sc = new Scanner(System.in);
		int rep;
		do{
			try{
				rep = Integer.parseInt(sc.next());
			}catch(Exception e){ rep = -1; }
		}while(rep!=1 && rep!=2);

		return String.valueOf(rep);
	}

	public int demandeNumRobot()
	{
		System.out.println("Quel robot voulez-vous reprogrammer ?");
		int nRobot;
		Scanner sc = new Scanner(System.in);
		do{
			try{
				nRobot = sc.nextInt()-1;
			}catch(Exception e){ nRobot=-1; }
		}while(nRobot<0 || nRobot>1);
		return nRobot;
	}

	public String[] demandeModifTour1(Joueur jCourant)
	{
		System.out.println("Choisir l'ordre à donner au robot :");
		String[] main   = jCourant.getMainOrdres();
		int[]    mainNb = jCourant.getMainNbOrdres();
		for(int i=0; i<main.length; i++)
			System.out.println("\t"+(i+1)+" "+main[i]+" (x"+mainNb[i]+")");

		Scanner  sc = new Scanner(System.in);
		int      rep;
		String retour ="";
		while(retour.equals(""))
		{
			System.out.print("Saisir un numéro d'ordre : ");
			try{
				rep = Integer.parseInt(sc.next());
			}catch(Exception e){ rep = 0; }
			if(rep>0 && rep<=main.length)
				retour = main[rep-1];
		}

		String[] tabRetour = new String[]{ retour, "", "" };
		return tabRetour;
	}

	public String[] demandeModif(Joueur jCourant, int numRobot)
	{
		//jCourant.resetCarte();
		String[] tabOrdres = jCourant.getOrdresRobot(numRobot);
		System.out.print(" - ");
		for(int i=0; i<tabOrdres.length; i++)
			System.out.print(tabOrdres[i]+" - ");
		System.out.println("\nChanger quel ordre ?");

		Scanner sc = new Scanner(System.in);
		int numOrdre;
		do{
			try{
				numOrdre = sc.nextInt()-1;
			}catch(Exception e){ numOrdre=-1; }
		}while(numOrdre<0||numOrdre>=3);

		System.out.println("Que voulez vous faire ?");
		System.out.println("\t1-Remplacer l'ordre par un ordre de la main");
		System.out.println("\t2-Echanger  l'ordre par un autre ordre du robot");
		System.out.println("\t3-Récupérer l'ordre dans la main");

		jCourant.actualiserMain();
		int indOption;
		do{
			try{
				indOption = sc.nextInt();
			}catch(Exception e){ indOption=-1; }
		}while(indOption<=0||indOption>3);

		if(indOption==1)
			return remplacerParMain(jCourant, numRobot, numOrdre);
		if(indOption==2)
			return remplacerParAutreOrdre(jCourant, numRobot, numOrdre);
		if(indOption==3)
			return recupOrdre(jCourant, numRobot, numOrdre);

		return null;
	}

	private String[] remplacerParMain(Joueur jCourant, int numRobot, int numOrdre)
	{
		String[] main   = jCourant.getMainOrdres();
		int[]    mainNb = jCourant.getMainNbOrdres();
		for(int i=0; i<main.length; i++)
			System.out.println("\t"+(i+1)+" "+main[i]+" (x"+mainNb[i]+")");

		System.out.println("Par quel ordre voulez le remplacer ?");
		Scanner sc = new Scanner(System.in);
		int numOrdreRemplace;
		do{
			try{
				numOrdreRemplace = sc.nextInt()-1;
			}catch(Exception e){ numOrdreRemplace=-1; }
		}while(numOrdreRemplace<0 || numOrdreRemplace>main.length-1);

		String[] tabOrdres = jCourant.getOrdresRobot(numRobot);
		for(int i=0; i<tabOrdres.length; i++)
			if(i==numOrdreRemplace)
				tabOrdres[i] = main[numOrdreRemplace];

		return tabOrdres;
	}

	private String[] remplacerParAutreOrdre(Joueur jCourant, int numRobot, int numOrdre)
	{
		System.out.println("Par quel ordre voulez le remplacer ?");
		String[] tabOrdres = jCourant.getOrdresRobot(numRobot);
		for(int i=0; i<tabOrdres.length; i++)
			System.out.println(i+"-"+tabOrdres[i]);

		Scanner sc = new Scanner(System.in);
		int numOrdreRemplace;
		do{
			try{
				numOrdreRemplace = sc.nextInt()-1;
			}catch(Exception e){ numOrdreRemplace=-1; }
		}while(numOrdreRemplace<0 || numOrdreRemplace>tabOrdres.length-1);

		String ordre = tabOrdres[numOrdre];
		tabOrdres[numOrdre]         = tabOrdres[numOrdreRemplace];
		tabOrdres[numOrdreRemplace] = ordre;

		return tabOrdres;
	}

	private String[] recupOrdre(Joueur jCourant, int numRobot, int numOrdre)
	{
		String[] tabOrdres = jCourant.getOrdresRobot(numRobot);
		tabOrdres[numOrdre] = "";

		for(int i=0; i<tabOrdres.length; i++)
			System.out.println(tabOrdres[i]);

		return tabOrdres;
	}

	public void victoire()
	{
		Console.println("Bravo le joueur x à gagner la partie !");
	}

	public void finDePartie(){
		Console.println(CouleurConsole.JAUNE.getFont()+"  _   _   _     _   _     _   _   _   _   _   _  \r\n / \\ / \\ / \\   / \\ / \\   / \\ / \\ / \\ / \\ / \\ / \\ \r\n( F | i | n ) ( d | e ) ( P | a | r | t | i | e )\r\n \\_/ \\_/ \\_/   \\_/ \\_/   \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ ");
	}
}
