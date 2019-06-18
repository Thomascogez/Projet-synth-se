import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;

public class PanelTerrain extends JPanel{
	private PanJoueur[] tabJoueur;
	private SpringLayout slPlateau;
	private double[] rotation ={Math.PI,Math.PI/2,Math.PI/2,-Math.PI,0,0};
	private Color[] couleurs = {Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW,Color.PINK,Color.MAGENTA};
	private int[] x = { 50,150,170,490,510,830,850,950,510,830,170,490}; 
	private int[] y = {460,140,130, 10,130, 10,460,140,130, 10,130, 10}; 
	// Constructor
	public PanelTerrain(){
		slPlateau = new SpringLayout();
		this.tabJoueur = new PanJoueur[6];
		this.setLayout(slPlateau);

		for (int i = 0;i<this.tabJoueur.length ;i++ ) {
			System.out.println ( rotation[i] );
			tabJoueur[i] = new PanJoueur(rotation[i]);
			tabJoueur[i].setBorder(new LineBorder(couleurs[i], 2));
			slPlateau.putConstraint(SpringLayout.NORTH, tabJoueur[i], y[2*i]   , SpringLayout.NORTH, this);
			slPlateau.putConstraint(SpringLayout.WEST,  tabJoueur[i], x[2*i]   , SpringLayout.WEST, this);
			slPlateau.putConstraint(SpringLayout.SOUTH, tabJoueur[i], y[2*i+1] , SpringLayout.NORTH, this);
			slPlateau.putConstraint(SpringLayout.EAST,  tabJoueur[i], x[2*i+1] , SpringLayout.WEST, this);
			this.add(tabJoueur[i]);
		}

		this.add(new JLabel("Hello World!", JLabel.CENTER));


		//this.add(new JLabel(new ImageIcon(new ImageIcon("Images/fond.jpg").getImage().getScaledInstance(1200, 800, Image.SCALE_DEFAULT))));
	}
	
}