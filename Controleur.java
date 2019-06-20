public class Controleur
{
	private IHMCUI  ihm;
	private Plateau metier;
	private int     numTour;
	private ChargementTest test;

	public Controleur()
	{

		this.ihm = new IHMCUI(this);
		this.metier = new Plateau(this.ihm.nouvellePartie());
		this.test = new ChargementTest(20);
		numTour = 0;
	}

	public int getJoueur(){return metier.getJoueur();}

	public void lancerPartie()
	{
		Joueur j1 = metier.getJoueurCourant();
		if(test.getProperty("TEST_MODE").trim().equals("TRUE"))
			{
				String[] tabSequence = test.getProperty("SEQUENCE_TEST").trim().split("#");

				for (String s : tabSequence) {
					metier.getJoueur(Integer.parseInt(s.split("/")[0].split(":")[0])).setTestOrdres(s.split("/")[1],Integer.parseInt(s.split("/")[0].split(":")[1]));

					System.out.println("Joueur N°"+s.split("/")[0].split(":")[0]);
					System.out.println("Robot N°"+s.split("/")[0].split(":")[1]);
					System.out.println("Séquence :"+s.split("/")[1]+"\n\n\n");
					this.ihm.afficherGrille(this.metier.afficherPlateau(), metier.getJoueurCourant());
					if(this.metier.getVictoire()){
						this.ihm.victoire();
						break;
					}
				}
			}
		while(!this.metier.getVictoire() ||test.getProperty("TEST_MODE").trim().equals("TRUE"))
		{
			Joueur joueur = metier.getJoueurCourant();
			if(joueur == j1)
				numTour++;

			this.ihm.afficherGrille(this.metier.afficherPlateau(), joueur);

			boolean valid = false;

				do
				{
					if(numTour == 1)
					{
						if(joueur.donnerOrdresModif(ihm.demandeModifTour1(joueur), 0) &&
						   joueur.donnerOrdresModif(ihm.demandeModifTour1(joueur), 1)   )
							valid = true;
						else
							System.out.println("\nOrdres invalides\n");
					}
					else
					{
						if(ihm.menuAction().equals("1"))
						{
							int numRobot, numAutreRobot;
							numRobot = ihm.demandeNumRobot();
							if(numRobot==0)
								numAutreRobot = 1;
							else
								numAutreRobot = 0;
							if(joueur.donnerOrdresModif(ihm.demandeModif(joueur, numRobot), numRobot))
							{
								joueur.donnerOrdres(numAutreRobot);
								valid = true;
							}
							else
								System.out.println("\nLa reprogrammation n'a pas été effectué\n");
						}

						else
						{
							joueur.donnerOrdres(0);
							joueur.donnerOrdres(1);
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
