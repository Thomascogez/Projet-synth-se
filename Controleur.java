/**
 * Classe Controleur
 * @author Quentin BERNARDIN
 * @author Mathieu BOIREAU
 * @author Thomas  COGEZ--ALLIX
 * @author Patrice MAISONNEUVE
 * @version 06-21-2019
 */

public class Controleur
{
	private IHMCUI  ihm;
	private Plateau metier;
	private int     numTour;
	private ChargementTest test;
	private boolean testMode;

	public Controleur()
	{

		this.ihm = new IHMCUI(this);
		this.metier = new Plateau(this.ihm.nouvellePartie());
		numTour = 0;
		testMode = false;
	}
	public Controleur(String arg)
	{
		this.ihm = new IHMCUI(this);
		this.metier = new Plateau(this.ihm.nouvellePartie());
		this.test = new ChargementTest(Integer.parseInt(arg));
		numTour = 0;
		testMode = true;
	}

	public int getJoueur(){return metier.getJoueur();}

	public void lancerPartie()
	{
		Joueur j1 = metier.getJoueurCourant();
		if(testMode)
		{
			String[] tabSequence = test.getProperty("SEQUENCE_TEST").trim().split("#");

			for (String s : tabSequence)
			{
				metier.getJoueur(Integer.parseInt(s.split("/")[0].split(":")[0])).setTestOrdres(s.split("/")[1],Integer.parseInt(s.split("/")[0].split(":")[1]));

				System.out.println("Joueur N°"+s.split("/")[0].split(":")[0]);
				System.out.println("Robot N°"+s.split("/")[0].split(":")[1]);
				System.out.println("Séquence :"+s.split("/")[1]+"\n\n\n");
				this.ihm.afficherGrille(this.metier.afficherPlateau(), metier.getJoueurCourant());
				if(this.metier.getVictoire())
				{
					this.ihm.getVictoirePoint(metier.getJoueurCourant());
					break;
				}
				
			}
			System.out.println("J1 R1 : "+metier.getJoueur(0).getCristalRobot(0));
			System.out.println("J1 R2 : "+metier.getJoueur(0).getCristalRobot(1));
			System.out.println("J2 R1 : "+metier.getJoueur(1).getCristalRobot(0));
			System.out.println("J2 R2 : "+metier.getJoueur(1).getCristalRobot(1));
			
		}
		while(!this.metier.getVictoirePoint()||!metier.getVictoireCrystal())
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

			if (!this.metier.getVictoirePoint()||!metier.getVictoireCrystal()) {
				metier.changerJoueur();
			}
		}
		if (this.metier.getVictoirePoint()) {this.ihm.victoire( metier.getJoueurCourant());}
		if (this.metier.getVictoireCrystal()) {this.ihm.victoir(metier.getMeileurJoueur());}
	}

	public static void main(String[] args)
	{
		//mode test
		if(args.length  == 1){
			new Controleur(args[0]).lancerPartie();
		//mode normal
		}else{
			new Controleur().lancerPartie();
		}

	}
}
