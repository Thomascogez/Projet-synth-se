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

		String[] tabRetour = new String[]{ retour };
		return tabRetour;
	}

	public String[] demandeModif(Joueur jCourant)
	{
		jCourant.resetCarte();
		System.out.println("Choisir les ordres à donner au robot (max 3, -1 pour arrêter) :");
		String[] main   = jCourant.getMainOrdres();
		int[]    mainNb = jCourant.getMainNbOrdres();
		for(int i=0; i<main.length; i++)
			System.out.println("\t"+(i+1)+" "+main[i]+" (x"+mainNb[i]+")");

		Scanner  sc = new Scanner(System.in);
		int      cpt = 0;
		int      rep;
		String[] tabRetour = new String[3];
		while(cpt<3)
		{
			System.out.print("Ordre "+(cpt+1)+" : ");

			try{
				rep = sc.nextInt();
			}catch(Exception e){ rep = 0; }

			if(rep == -1 && cpt>0)
				break;

			if(rep>0 && rep<main.length && mainNb[rep-1]>0)
			{
				tabRetour[cpt] = main[rep-1];
				cpt++;
			}
			else
				System.out.println("Ordre invalide");
		}

		return tabRetour;
	}

	public void victoire()
	{
		Console.println("Bravo le joueur x à gagner la partie !");
	}

	public void finDePartie(){
		Console.println(CouleurConsole.JAUNE.getFont()+"  _   _   _     _   _     _   _   _   _   _   _  \r\n / \\ / \\ / \\   / \\ / \\   / \\ / \\ / \\ / \\ / \\ / \\ \r\n( F | i | n ) ( d | e ) ( P | a | r | t | i | e )\r\n \\_/ \\_/ \\_/   \\_/ \\_/   \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ ");
	}
}
