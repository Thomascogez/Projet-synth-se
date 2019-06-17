import iut.algo.*;
public class IHMCUI
{
	public IHMCUI()
	{

	}

	public String[] nouvellePartie()
	{
		//Initialisation : on demande le nombre de joueurs, avec vérification...
		System.out.print ( "Choix du nombre de joueurs [2..6] : " );
		int nbJoueurMax = Clavier.lire_int();

		while (nbJoueurMax>6||nbJoueurMax<2)
		{
			System.out.println ( "ERREUR : Choix du nombre de joueurs invalide !" );
			System.out.print ( "Choix du nombre de joueurs [2..6] : " );
			nbJoueurMax = Clavier.lire_int();
		}
		//...Et on demande leurs noms respectifs
		String[] tabNom = new String[nbJoueurMax];
		for (int i= 0; i< nbJoueurMax ;i++ )
		{
			System.out.print ("Nom du Joueur " +(i+1)+ " : ");
			tabNom[i] = Clavier.lireString();
		}
		return tabNom;
	}

	public void afficherGrille(String grille)
	{
		System.out.println(grille);
	}
}
