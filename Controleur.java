public class Controleur
{
	IHMCUI  ihm;
	Plateau metier;
	public Controleur()
	{
		this.ihm = new IHMCUI();
		this.metier = new Plateau(this.ihm.nouvellePartie());
	}

	public void lancerPartie()
	{
		this.ihm.afficherGrille(this.metier.afficherPlateau());
		while(!this.metier.getVictoire())
		{

		}
		this.ihm.victoire();
	}


	public static void main(String[] args)
	{
		new Controleur().lancerPartie();
	}
}
