public class Controleur
{
	private IHMCUI  ihm;
	private Plateau metier;
	private int     numTour;
	private ChargementTest test;

	public Controleur()
	{

		this.ihm = new IHMCUI();
		this.metier = new Plateau(this.ihm.nouvellePartie());
		this.test = new ChargementTest(1);
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
				if(test.getProperty("TEST_MODE").trim().equals("TRUE"))
				{
					String[] sequence =
				}
				else
				{

			
				if(numTour == 1)
				{
					if(joueur.donnerOrdresModif(ihm.demandeModifTour1(metier.getJoueurCourant()), 0) &&
					   joueur.donnerOrdresModif(ihm.demandeModifTour1(metier.getJoueurCourant()), 1)   )
						valid = true;
					else
						System.out.println("\nOrdres invalides\n");
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
