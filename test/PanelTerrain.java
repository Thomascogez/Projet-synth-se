import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;

public class PanelTerrain extends JPanel {
	private PanJoueur[] tabJoueur;
	private SpringLayout slPlateau;
	private double[] rotation = { Math.PI, Math.PI / 2, Math.PI / 2, -Math.PI, 0, 0 };
	private Color[] couleurs = { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.PINK, Color.MAGENTA };
	private int[] x = { 50, 150, 170, 490, 510, 830, 850, 950, 510, 830, 170, 490 };
	private int[] y = { 460, 140, 130, 10, 130, 10, 460, 140, 130, 10, 130, 10 };
	

	// Constructor
	public PanelTerrain() {
		slPlateau = new SpringLayout();
		this.tabJoueur = new PanJoueur[6];
		this.setLayout(slPlateau);
		
		// this.add(new JLabel("Hello World!", JLabel.CENTER));
		// this.add(new PanJoueur(rotation[0]));
		// this.add(new PanJoueur(rotation[1]));
		// this.add(new PanJoueur(rotation[2]));
		// this.add(new PanJoueur(rotation[3]));
		// this.add(new PanJoueur(rotation[4]));
		// this.add(new PanJoueur(rotation[5]));
		this.setUpPanel();
		// this.add(new JLabel(new ImageIcon(new
		// ImageIcon("Images/fond.jpg").getImage().getScaledInstance(1200, 800,
		// Image.SCALE_DEFAULT))));
	}

	public void setUpPanel() {
		for (int i = 0; i < 1; i++) {
			System.out.println(rotation[i]);
			tabJoueur[i] = new PanJoueur(rotation[i]);
			tabJoueur[i].setBorder(new LineBorder(couleurs[i], 2));
			slPlateau.putConstraint(SpringLayout.NORTH, tabJoueur[i], 10, SpringLayout.SOUTH, this);
			slPlateau.putConstraint(SpringLayout.WEST, tabJoueur[i],10, SpringLayout.WEST, this);
			slPlateau.putConstraint(SpringLayout.SOUTH, tabJoueur[i], 10, SpringLayout.NORTH, this);
			slPlateau.putConstraint(SpringLayout.EAST, tabJoueur[i], 10, SpringLayout.WEST, this);
			this.add(tabJoueur[i]);
		}

		// for (Component c : this.getComponents()) {
		// 	for (Component sc : ((JPanel) c).getComponents()) {
		// 		System.out.println(sc);
		// 	}
		// }
	}

}