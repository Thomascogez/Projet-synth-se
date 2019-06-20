import javax.swing.*;
import java.awt.*;

import javax.swing.border.*;
import java.awt.event.*;

public class IHMLauncheur extends JFrame {

	private PanJoueur[] tabJoueur;
	private JPanel action;
	private int joueur;
	private Color[] couleurs = {  Color.RED,Color.YELLOW,Color.GREEN,Color.BLUE,Color.MAGENTA,Color.PINK };
	public static void main(String[] args) {

		IHMLauncheur frame = new IHMLauncheur();
		frame.setVisible(true);
	}

	public IHMLauncheur() {
		joueur = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.tabJoueur = new PanJoueur[6];
		JPanel contentPane = new JPanel();
		add(contentPane);
		contentPane.setLayout(new BorderLayout());

		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur = (int)tailleEcran.getHeight();
		int largeur = (int)tailleEcran.getWidth();
		
		JPanel plateau = new JPanel();
		contentPane.add(plateau, BorderLayout.CENTER);
		SpringLayout spGeneral = new SpringLayout();
		plateau.setLayout(spGeneral);

		JPanel terrain = new JPanel();
		terrain.setLayout(new BorderLayout());
		spGeneral.putConstraint(SpringLayout.NORTH, terrain, hauteur/9, SpringLayout.NORTH, plateau);
		spGeneral.putConstraint(SpringLayout.WEST, terrain, largeur/4, SpringLayout.WEST, plateau);
		spGeneral.putConstraint(SpringLayout.SOUTH, terrain,  hauteur/2+ hauteur/8, SpringLayout.NORTH, plateau);
		spGeneral.putConstraint(SpringLayout.EAST, terrain, largeur-largeur/4, SpringLayout.WEST, plateau);
		plateau.add(terrain);
		terrain.add(new JLabel(new ImageIcon(new ImageIcon("Images/board2.jpg").getImage().getScaledInstance(largeur-largeur/2, hauteur- hauteur/2+hauteur/30, Image.SCALE_SMOOTH))));

		JPanel joueur_1 = new JPanel();
		tabJoueur[0] = new PanJoueur(0  ,largeur,this);
		tabJoueur[0].setBorder(new LineBorder(couleurs[0], 5));
		spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[0], -90, SpringLayout.NORTH, terrain);
		spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[0], largeur/30, SpringLayout.WEST, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[0], -10, SpringLayout.NORTH, terrain);
		spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[0], largeur/5, SpringLayout.WEST, terrain);
		plateau.add(tabJoueur[0]);

		tabJoueur[1] = new PanJoueur(1  ,largeur,this);
		tabJoueur[1].setBorder(new LineBorder(couleurs[1], 2));
		spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[1], -90, SpringLayout.NORTH, terrain);
		spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[1], -largeur/5, SpringLayout.EAST, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[1], -10, SpringLayout.NORTH, terrain);
		spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[1], -largeur/30, SpringLayout.EAST, terrain);
		plateau.add(tabJoueur[1]);

		tabJoueur[2] = new PanJoueur(2  ,largeur,this);
		tabJoueur[2].setBorder(new LineBorder(couleurs[2], 2));
		spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[2], hauteur/3-hauteur/20, SpringLayout.NORTH, plateau);
		spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[2], 10, SpringLayout.EAST, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[2], hauteur/3+hauteur/20, SpringLayout.NORTH, plateau);
		spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[2], 280, SpringLayout.EAST, terrain);
		plateau.add(tabJoueur[2]);
		
		tabJoueur[3] = new PanJoueur(3 ,largeur,this);
		tabJoueur[3].setBorder(new LineBorder(couleurs[3], 2));
		spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[3], 10, SpringLayout.SOUTH, terrain);
		spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[3], -largeur/5, SpringLayout.EAST, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[3], 90, SpringLayout.SOUTH, terrain);
		spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[3], -largeur/30, SpringLayout.EAST, terrain);
		plateau.add(tabJoueur[3]);

		tabJoueur[4] = new PanJoueur(4  ,largeur,this);
		tabJoueur[4].setBorder(new LineBorder(couleurs[4], 2));
		spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[4], 10, SpringLayout.SOUTH, terrain);
		spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[4], largeur/30, SpringLayout.WEST, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[4], 90, SpringLayout.SOUTH, terrain);
		spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[4], largeur/5, SpringLayout.WEST, terrain);
		plateau.add(tabJoueur[4]);

		tabJoueur[5] = new PanJoueur(5  ,largeur,this);
		tabJoueur[5].setBorder(new LineBorder(couleurs[5], 2));
		spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[5], hauteur/3-hauteur/20, SpringLayout.NORTH, plateau);
		spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[5], -280, SpringLayout.WEST, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[5], hauteur/3+hauteur/20, SpringLayout.NORTH, plateau);
		spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[5], -10, SpringLayout.WEST, terrain);
		plateau.add(tabJoueur[5]);

		action = new JPanel();
		action.setLayout(new BorderLayout());
		spGeneral.putConstraint(SpringLayout.NORTH, action, hauteur-hauteur/5, SpringLayout.NORTH, plateau);
		spGeneral.putConstraint(SpringLayout.WEST, action, largeur/5, SpringLayout.WEST, plateau);
		spGeneral.putConstraint(SpringLayout.SOUTH, action, hauteur-hauteur/30 , SpringLayout.NORTH, plateau);
		spGeneral.putConstraint(SpringLayout.EAST, action, largeur-largeur/5, SpringLayout.WEST, plateau);
		plateau.add(action);

		action.add(tabJoueur[joueur].getPanAction());


		plateau.add(new JLabel(new ImageIcon(new ImageIcon("Images/fond.jpg").getImage().getScaledInstance(largeur, hauteur, Image.SCALE_DEFAULT))));

	}

	public void finTour()
	{
		tabJoueur[joueur].setBorder(new LineBorder(couleurs[joueur], 2));
		joueur = (joueur +1) % tabJoueur.length;
		action.removeAll();
		//tabJoueur[joueur].majFinTour();
		action.add(tabJoueur[joueur].getPanAction());
		tabJoueur[joueur].setBorder(new LineBorder(couleurs[joueur], 5));
		this.revalidate();
		this.repaint();
	}
}
