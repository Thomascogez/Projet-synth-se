import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class PanJoueur extends JPanel{
	private JLabel lblprog;
	private PanAction action;
	private int nbJoueur;
	// Constructor
	public PanJoueur(int nbJoueur,int x, IHMLauncheur frame){
		this.nbJoueur =nbJoueur;
		this.setLayout(new BorderLayout());
		action = new PanAction(this.nbJoueur, frame,x);
		
	}

	public PanAction getPanAction(){return action;}

	//public void majFinTour(){this.add(action.getPanPrograme());}

}
