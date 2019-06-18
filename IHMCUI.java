import java.util.ArrayList;

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

	public void afficherGrille(String grille)
	{
		System.out.println(grille);
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
	public void menuAction() {
        Console.println("\tVoulez-vous modifier un programme avant execution ? : \n\n" + "\t\t"+ CouleurConsole.VERT.getFont() +" 1 - Oui\n" + "\t\t"+ CouleurConsole.ROUGE.getFont() +" 2 - Non");
        Console.normal();
    }

    public void victoire()
    {
    	Console.println("Bravo le joueur x à gagner la partie !");
    }

	public void finDePartie(){
		Console.println(CouleurConsole.JAUNE.getFont()+"  _   _   _     _   _     _   _   _   _   _   _  \r\n / \\ / \\ / \\   / \\ / \\   / \\ / \\ / \\ / \\ / \\ / \\ \r\n( F | i | n ) ( d | e ) ( P | a | r | t | i | e )\r\n \\_/ \\_/ \\_/   \\_/ \\_/   \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ ");
	}
}