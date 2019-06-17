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
		while(!this.metier.getVictoire())
		{
		this.ihm.afficherGrille(this.metier.afficherPlateau());

		}
	}


	public static void main(String[] args)
	{
		new Controleur().lancerPartie();
	}
}
