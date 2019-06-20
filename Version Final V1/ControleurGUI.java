public class ControleurGUI {

	private Plateau metier;
	private IHMLauncheur ihm;
	private int numTour;

	public ControleurGUI(){
		new LauncherIhm(this);
	}

	public void nouveauplateau(String[] tabNomJoueur)
	{
		this.metier = new Plateau(tabNomJoueur,this);
		this.ihm    = new IHMLauncheur(tabNomJoueur.length,this);
		lancerPartie();
	}

	public void lancerPartie()
	{
		Joueur j1 = metier.getJoueurCourant();

		Joueur joueur = metier.getJoueurCourant();
		if(joueur == j1)
			numTour++;

		boolean valid = false;
		/*do
		{
			if(numTour == 1)
			{
				if()
					valid = true;
			}
			else
			{
				;
			}
		}while(!valid);
*/
		ihm.finTour(metier.changerJoueur(), metier.getNbJoueurs()); // Maj ihm à la fin
	}

	public static void main(String[] args){
		new ControleurGUI();
	}
}