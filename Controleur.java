public class Controleur
{
	IHMCUI  ihm;
	Plateau metier;
	int     numTour;
	public Controleur()
	{
		this.ihm = new IHMCUI();
		this.metier = new Plateau(this.ihm.nouvellePartie());
		numTour = 0;
	}

	public void lancerPartie()
	{
		Joueur j1 = metier.getJoueurCourant();
		while(!this.metier.getVictoire())
		{
			Joueur joueur = metier.getJoueurCourant();
			if(joueur == j1)
				numTour++;

			this.ihm.afficherGrille(this.metier.afficherPlateau(), joueur);

			boolean valid = false;
			do{
				if(numTour == 1)
				{
					if(joueur.donnerOrdresModif(ihm.demandeModifTour1(metier.getJoueurCourant()), 0) &&
					   joueur.donnerOrdresModif(ihm.demandeModifTour1(metier.getJoueurCourant()), 1)   )
						valid = true;
					else
						System.out.println("Ordres invalides");
				}
				else
				{
					if(ihm.menuAction().equals("1"))
					{
						if(joueur.donnerOrdresModif(ihm.demandeModif(metier.getJoueurCourant()),
						                            ihm.demandeNumRobot()                       ))
							valid = true;
						else
							System.out.println("Ordres invalides");
					}

					else
					{
						joueur.donnerOrdres(ihm.demandeNumRobot());
						valid = true;
					}
				}
			}while(!valid);

			metier.changerJoueur();
		}
		this.ihm.victoire();
	}



	public static void main(String[] args)
	{
		new Controleur().lancerPartie();
	}
}
