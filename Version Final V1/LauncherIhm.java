import java.awt.event.*;

import java.awt.*;
import javax.swing.*;

public class LauncherIhm extends JFrame{
	private PanImage panelAccueil;
	private DemandeJoueur panelDemandeJ;
	private PanNomJoueurs panNomsJ;
	private ControleurGUI ctrl;
	private int nbJoueurs;

	public LauncherIhm(ControleurGUI ctrl) {
		this.setResizable(false);
		this.setSize(515, 750);
		this.ctrl = ctrl;
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panelAccueil  = new PanImage(this);
		this.panelDemandeJ = new DemandeJoueur(this);
		this.setContentPane(this.panelAccueil);	
		this.setVisible(true);
	}

	public void addPanDemandeJ()
	{
		this.panelDemandeJ.setVisible(true);
	}
	public void setNbJ(int i)
	{
		this.nbJoueurs=i;
		this.panNomsJ = new PanNomJoueurs(this.nbJoueurs,this);
	}

	public void debuterPartie(String[] tabNomJoueur)
	{
		this.ctrl.nouveauplateau(tabNomJoueur);
		this.dispose();
	}
}
