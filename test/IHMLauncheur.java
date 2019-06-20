import javax.swing.*;
import java.awt.*;

import javax.swing.border.*;
import java.awt.event.*;

public class IHMLauncheur extends JFrame {

	private PanJoueur[] tabJoueur;
	private JPanel action;
	private int joueur;
	private Color[] couleurs = {  Color.RED,Color.YELLOW,Color.GREEN,Color.BLUE,Color.MAGENTA,Color.PINK };

	public IHMLauncheur(int nbJoueurMax) {
		joueur = 0;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.tabJoueur = new PanJoueur[nbJoueurMax];
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
		if (nbJoueurMax>4) {
			terrain.add(new JLabel(new ImageIcon(new ImageIcon("Images/board2.jpg").getImage().getScaledInstance(largeur-largeur/2, hauteur- hauteur/2+hauteur/30, Image.SCALE_SMOOTH))));
		}
		else {
			terrain.add(new JLabel(new ImageIcon(new ImageIcon("Images/board1.jpg").getImage().getScaledInstance(largeur-largeur/2, hauteur- hauteur/2+hauteur/30, Image.SCALE_SMOOTH))));
		}
		

		JPanel joueur_1 = new JPanel();

		tabJoueur[joueur] = new PanJoueur(joueur  ,largeur,this);
		tabJoueur[joueur].setBorder(new LineBorder(couleurs[joueur], 5));
		spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[joueur], -90, SpringLayout.NORTH, terrain);
		spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[joueur], largeur/40, SpringLayout.WEST, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[joueur], -10, SpringLayout.NORTH, terrain);
		spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[joueur], largeur/5, SpringLayout.WEST, terrain);
		plateau.add(tabJoueur[joueur]);
		joueur++;

		tabJoueur[joueur] = new PanJoueur(joueur  ,largeur,this);
		tabJoueur[joueur].setBorder(new LineBorder(couleurs[joueur], 2));
		spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[joueur], -90, SpringLayout.NORTH, terrain);
		spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[joueur], -largeur/5, SpringLayout.EAST, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[joueur], -10, SpringLayout.NORTH, terrain);
		spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[joueur], -largeur/40, SpringLayout.EAST, terrain);
		plateau.add(tabJoueur[joueur]);
		joueur++;

		if (nbJoueurMax>2) {
			
			tabJoueur[joueur] = new PanJoueur(joueur  ,largeur,this);
			tabJoueur[joueur].setBorder(new LineBorder(couleurs[joueur], joueur));
			spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[joueur], hauteur/3-hauteur/20, SpringLayout.NORTH, plateau);
			spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[joueur], 10, SpringLayout.EAST, terrain);
			spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[joueur], hauteur/3+hauteur/20, SpringLayout.NORTH, plateau);
			spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[joueur], 280, SpringLayout.EAST, terrain);
			plateau.add(tabJoueur[joueur]);
			joueur++;

			if (nbJoueurMax>3) {
				tabJoueur[joueur] = new PanJoueur(joueur  ,largeur,this);
				tabJoueur[joueur].setBorder(new LineBorder(couleurs[joueur], 2));
				spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[joueur], 10, SpringLayout.SOUTH, terrain);
				spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[joueur], largeur/40, SpringLayout.WEST, terrain);
				spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[joueur], 90, SpringLayout.SOUTH, terrain);
				spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[joueur], largeur/5, SpringLayout.WEST, terrain);
				plateau.add(tabJoueur[joueur]);
				joueur++;
				if (nbJoueurMax>4) {
					tabJoueur[joueur] = new PanJoueur(joueur ,largeur,this);
					tabJoueur[joueur].setBorder(new LineBorder(couleurs[joueur], 2));
					spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[joueur], 10, SpringLayout.SOUTH, terrain);
					spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[joueur], -largeur/5, SpringLayout.EAST, terrain);
					spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[joueur], 90, SpringLayout.SOUTH, terrain);
					spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[joueur], -largeur/40, SpringLayout.EAST, terrain);
					plateau.add(tabJoueur[joueur]);
					joueur++;
					if (nbJoueurMax>5) {
						tabJoueur[joueur] = new PanJoueur(joueur  ,largeur,this);
						tabJoueur[joueur].setBorder(new LineBorder(couleurs[joueur], 2));
						spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[joueur], hauteur/3-hauteur/20, SpringLayout.NORTH, plateau);
						spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[joueur], -280, SpringLayout.WEST, terrain);
						spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[joueur], hauteur/3+hauteur/20, SpringLayout.NORTH, plateau);
						spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[joueur], -10, SpringLayout.WEST, terrain);
						plateau.add(tabJoueur[joueur]);					
						joueur++;
					}
				}
			}			
		}


		
		joueur = 0;
		tabJoueur[joueur].setBorder(new LineBorder(couleurs[0], 5));

		action = new JPanel();
		action.setLayout(new BorderLayout());
		spGeneral.putConstraint(SpringLayout.NORTH, action, hauteur-hauteur/5, SpringLayout.NORTH, plateau);
		spGeneral.putConstraint(SpringLayout.WEST, action, largeur/5, SpringLayout.WEST, plateau);
		spGeneral.putConstraint(SpringLayout.SOUTH, action, hauteur-hauteur/30 , SpringLayout.NORTH, plateau);
		spGeneral.putConstraint(SpringLayout.EAST, action, largeur-largeur/5, SpringLayout.WEST, plateau);
		plateau.add(action);

		action.add(tabJoueur[joueur].getPanAction());


		plateau.add(new JLabel(new ImageIcon(new ImageIcon("Images/fond.jpg").getImage().getScaledInstance(largeur, hauteur, Image.SCALE_DEFAULT))));
		this.setVisible(true);

	}

	public void finTour()
	{
		tabJoueur[joueur].setBorder(new LineBorder(couleurs[joueur], 2));
		tabJoueur[joueur].majFinTour();
		joueur = (joueur +1) % tabJoueur.length;
		action.removeAll();	
		action.add(tabJoueur[joueur].getPanAction());
		tabJoueur[joueur].setBorder(new LineBorder(couleurs[joueur], 5));
		this.revalidate();
		this.repaint();
	}
}
