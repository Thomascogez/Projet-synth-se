
public class ControleurGUI {

	private Plateau metier;
	private IHMLauncheur plateau;
	public ControleurGUI(){
		new LauncherIhm(this);
	}

	public void nouveauplateau(String[] tabNomJoueur)
	{
		this.metier = new Plateau(tabNomJoueur,this);
		this.plateau = new IHMLauncheur(tabNomJoueur.length,this);
	}


	public static void main(String[] args){
		new ControleurGUI();
	}
	
}