
public class ControleurGUI {
	
	private IHMLauncheur plateau;
	public ControleurGUI(){
		new LauncherIhm(this);
	}

	public void nouveauplateau(String[] tabNomJoueur)
	{
		this.plateau = new IHMLauncheur(tabNomJoueur.length);
	}


	public static void main(String[] args){
		new ControleurGUI();
	}
	
}