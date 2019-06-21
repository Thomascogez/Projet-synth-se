import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe IHM
 * @author Quentin BERNARDIN
 * @author Mathieu BOIREAU
 * @author Thomas  COGEZ--ALLIX
 * @author Patrice MAISONNEUVE
 * @version 06-21-2019
 */

import iut.algo.*;
// TODO: Auto-generated Javadoc

/**
 * The Class IHMCUI.
 */
public class IHMCUI
{
	
	/** The coul joueur. */
	// SUPPRIME
	CouleurConsole[] coulJoueur = {CouleurConsole.valueOf("ROUGE"),CouleurConsole.valueOf("JAUNE"),
	                               CouleurConsole.valueOf("VERT") ,CouleurConsole.valueOf("BLEU"),
								   CouleurConsole.valueOf("MAUVE"),CouleurConsole.valueOf("BLANC")};
	
	/** Controleur qui fait la liaison avec la partie métier. */
	private Controleur ctrl;

	/**
	 * Constructeur permettant de stocker le controleur.
	 *
	 * @param ctrl the ctrl
	 */
	public IHMCUI(Controleur ctrl){this.ctrl = ctrl;}

	/**
	 * Méthode appelée au début d'une nouvelle partie pour afficher le nom du jeu.
	 */
	private void ecranDemarrage()
	{
		System.out.println(
		        "  _   _   _   _     _   _   _     _   _   _   _  \r\n / \\ / \\ / \\ / \\   / \\ / \\ / \\   / \\ / \\ / \\ / \\ \r\n( T | w | i | n ) ( T | i | n ) ( B | o | t | s )\r\n \\_/ \\_/ \\_/ \\_/   \\_/ \\_/ \\_/   \\_/ \\_/ \\_/ \\_/ \n");
	}

	/**
	 * Affiche l'écran de démarrage puis demande le nombre de joueurs et leur nom.
	 *
	 * @return the string[]
	 */
	public String[] nouvellePartie()
	{
		ecranDemarrage();
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
			Console.print (coulJoueur[i].getFont()+"Nom du Joueur " +(i+1)+ " : ");
			Console.normal();
			tabNom[i] = Clavier.lireString();
		}
		return tabNom;
	}

	/**
	 * Affiche le plateau avec le tour du joueur et son score.
	 *
	 * @param grille the grille
	 * @param joueur the joueur
	 */
	public void afficherGrille(String grille, Joueur joueur)
	{
		System.out.println(grille);
		Console.println (coulJoueur[ctrl.getJoueur()].getFont()+"Tour du Joueur " + joueur.getNom() + "| Point : "+joueur.getPoints()+"");
		Console.normal();
	}

	/* SUPPRIME
	public void afficherScores(ArrayList<Joueur> lJoueur)
	{
		System.out.println("+------------+-----------+");
		System.out.println("|      Joueur|      Score|");
		System.out.println("+------------+-----------+");
		for (Joueur j : lJoueur)
			Console.println(String.format("|"+CouleurConsole.VERT.getFont()+" %10s"+CouleurConsole.JAUNE.getFont()+" | "+CouleurConsole.JAUNE.getFont()+"%3d points"+CouleurConsole.BLANC.getFont()+"|", j.getNom(), j.getPoint()));

		Console.normal();
		System.out.println("+------------+-----------+");

	}*/

	/**
	 * Demande au joueur s'il veut consulter ou reprogrammer un de ses robots.
	 *
	 * @return the string
	 */
	public String menuAction() {
		Console.println("\tVoulez-vous modifier/consulter un programme avant execution ? : \n\n" +
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

	/**
	 * Demande au joueur le robot qu'il veut consulter/modifier par son numéro.
	 *
	 * @return the int
	 */
	public int demandeNumRobot()
	{
		System.out.println("Quel robot voulez-vous reprogrammer/consulter ?");
		int nRobot;
		Scanner sc = new Scanner(System.in);
		do{
			try{
				nRobot = sc.nextInt()-1;
			}catch(Exception e){ nRobot=-1; }
		}while(nRobot<0 || nRobot>1);
		return nRobot;
	}

	/**
	 * Demande au joueur quel ordre il veut donner à un robot au premier tour.
	 *
	 * @param jCourant the j courant
	 * @return the string[]
	 */
	public String[] demandeModifTour1(Joueur jCourant)
	{
		System.out.println("Choisir l'ordre à donner au robot :");
		String[] main   = jCourant.getMainOrdres();
		int[]    mainNb = jCourant.getMainNbOrdres();
		for(int i=0; i<main.length; i++)
			{System.out.println("\t"+(i+1)+" "+main[i]+" (x"+mainNb[i]+")");}
			System.out.println("Saisir un numéro d'ordre : ");
		Scanner  sc = new Scanner(System.in);
		int      rep;
		String retour ="";
		while(retour.equals(""))
		{
			try{
				rep = sc.nextInt();
			}catch(Exception e){ rep = 0; }
			if(rep>0 && rep<=main.length)
				retour = main[rep-1];
		}

		String[] tabRetour = new String[]{ retour, "", "" };
		return tabRetour;
	}

	/**
	 * Affiche des informations sur le robot choisi,
	 * demande au joueur s'il veut modifier son robot et
	 * quel modification il veut faire.
	 *
	 * @param jCourant the j courant
	 * @param numRobot the num robot
	 * @return the string[]
	 */
	public String[] demandeModif(Joueur jCourant, int numRobot)
	{
		// Affiche des informations sur le robot
		int dirRobot = jCourant.getDirRobot(numRobot);
		String infoDir = "\tDirection du robot : ";
		if(dirRobot==0)
			infoDir+="Haut";
		if(dirRobot==1)
			infoDir+="Haut Droite";
		if(dirRobot==2)
			infoDir+="Bas Droite";
		if(dirRobot==3)
			infoDir+="Bas";
		if(dirRobot==4)
			infoDir+="Bas Gauche";
		if(dirRobot==5)
			infoDir+="Haut Gauche";
		System.out.println(infoDir+"\n");

		String[] tabOrdres = jCourant.getOrdresRobot(numRobot);
		System.out.print(" - ");
		for(int i=0; i<tabOrdres.length; i++)
			System.out.print(tabOrdres[i]+" - ");
		if(jCourant.getCristalRobot(numRobot) != 0)
		{
			System.out.println("Contenu du Robot : " + jCourant.getCristalRobot(numRobot));
		}
		else
		{
			System.out.println("Robot vide ");
		}
		
		// Demande au joueur s'il veut modifier son robot
		Scanner sc = new Scanner(System.in);
		int     rep;
		System.out.println("\nVoulez-vous reprogrammer le robot ?\n"+
		                   "\t1-Oui\n\t2-Non");
		do{
			try{
				rep = sc.nextInt();
			}catch(Exception e){ rep=-1; }
		}while(rep!=1 && rep!=2);

		// Si le joueur ne veut pas reprogrammer le robot,
		// on envoie une série d'ordre impossible (1 Avancer2 au maximum par joueur)
		if(rep==2)
			return new String[]{"Avancer2","Avancer2","Avancer2"};

		// Début reprogrammation
		System.out.println("\nChanger quel ordre ?");

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

	/**
	 * Demande au joueur par quel ordre de leur main il veut remplacer l'ordre choisi du robot.
	 *
	 * @param jCourant the j courant
	 * @param numRobot the num robot
	 * @param numOrdre the num ordre
	 * @return the string[]
	 */
	private String[] remplacerParMain(Joueur jCourant, int numRobot, int numOrdre)
	{
		String[] main   = jCourant.getMainOrdres();
		int[]    mainNb = jCourant.getMainNbOrdres();
		// Affiche les ordres en main et leur quantité
		for(int i=0; i<main.length; i++)
			System.out.println("\t"+(i+1)+" "+main[i]+" (x"+mainNb[i]+")");

		// Demande au joueur l'ordre de la main qu'il veut
		System.out.println("Par quel ordre voulez le remplacer ?");
		Scanner sc = new Scanner(System.in);
		int numOrdreRemplace;
		do{
			try{
				numOrdreRemplace = sc.nextInt()-1;
			}catch(Exception e){ numOrdreRemplace=-1; }
		}while(numOrdreRemplace<0 || numOrdreRemplace>main.length-1);

		String[] tabOrdres = jCourant.getOrdresRobot(numRobot);

		tabOrdres[numOrdre] = main[numOrdreRemplace];
		return tabOrdres;
	}

	/**
	 * Demande au joueur par quel ordre du robot il veut remplacer l'ordre choisi du robot.
	 *
	 * @param jCourant the j courant
	 * @param numRobot the num robot
	 * @param numOrdre the num ordre
	 * @return the string[]
	 */
	private String[] remplacerParAutreOrdre(Joueur jCourant, int numRobot, int numOrdre)
	{
		System.out.println("Par quel ordre voulez le remplacer ?");
		String[] tabOrdres = jCourant.getOrdresRobot(numRobot);
		for(int i=0; i<tabOrdres.length; i++)
			System.out.println("\t"+(i+1)+"-"+tabOrdres[i]);

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

	/**
	 * Permet de récupérer l'ordre choisi en paramètre.
	 *
	 * @param jCourant the j courant
	 * @param numRobot the num robot
	 * @param numOrdre the num ordre
	 * @return the string[]
	 */
	private String[] recupOrdre(Joueur jCourant, int numRobot, int numOrdre)
	{
		String[] tabOrdres = jCourant.getOrdresRobot(numRobot);
		tabOrdres[numOrdre] = "";

		for(int i=0; i<tabOrdres.length; i++)
			System.out.println(tabOrdres[i]);

		return tabOrdres;
	}

	/**
	 * Affiche un message de victoire.
	 *
	 * @param joueur the joueur
	 */
	public void victoire(Joueur joueur)
	{
		Console.println("Bravo "+ joueur.getNom() +"  à gagner la partie !");
	}

	/**
	 * Affiche un message de fin de partie.
	 */
	public void finDePartie(){
		Console.println(CouleurConsole.JAUNE.getFont()+"  _   _   _     _   _     _   _   _   _   _   _  \r\n / \\ / \\ / \\   / \\ / \\   / \\ / \\ / \\ / \\ / \\ / \\ \r\n( F | i | n ) ( d | e ) ( P | a | r | t | i | e )\r\n \\_/ \\_/ \\_/   \\_/ \\_/   \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ ");
	}
}
