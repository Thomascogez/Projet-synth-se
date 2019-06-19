import javax.swing.*;
import java.awt.*;

import javax.swing.border.*;
import java.awt.event.*;

public class IHMLauncheur extends JFrame {

	private double[] rotation = { Math.PI, Math.PI,0,0, -Math.PI/2,Math.PI / 2};
	private PanJoueur[] tabJoueur;
	private Color[] couleurs = { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.PINK, Color.MAGENTA };
	//private Dimension[]dim = {new Dimension(100, 320),new Dimension(320, 100)};
	public static void main(String[] args) {

		IHMLauncheur frame = new IHMLauncheur();
		frame.setVisible(true);
	}

	public IHMLauncheur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.tabJoueur = new PanJoueur[6];
		JPanel contentPane = new JPanel();
		add(contentPane);
		contentPane.setLayout(new BorderLayout());

		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur = (int)tailleEcran.getHeight();
		int largeur = (int)tailleEcran.getWidth();

		System.out.println ( hauteur+" : "+largeur );

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout());

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("Images/tableau_prog.jpg"));
		panel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);

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
		terrain.add(new JLabel(new ImageIcon(new ImageIcon("Images/board1.jpg").getImage().getScaledInstance(largeur-largeur/2, hauteur- hauteur/2+hauteur/30, Image.SCALE_SMOOTH))));

		JPanel joueur_1 = new JPanel();
		tabJoueur[0] = new PanJoueur(rotation[0]  ,largeur,hauteur);
		tabJoueur[0].setBorder(new LineBorder(Color.RED, 2));
		spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[0], -90, SpringLayout.NORTH, terrain);
		spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[0], largeur/30, SpringLayout.WEST, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[0], -10, SpringLayout.NORTH, terrain);
		spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[0], largeur/5, SpringLayout.WEST, terrain);
		plateau.add(tabJoueur[0]);

		tabJoueur[1] = new PanJoueur(rotation[1]  ,largeur,hauteur);
		tabJoueur[1].setBorder(new LineBorder(Color.YELLOW, 2));
		spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[1], -90, SpringLayout.NORTH, terrain);
		spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[1], -largeur/5, SpringLayout.EAST, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[1], -10, SpringLayout.NORTH, terrain);
		spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[1], -largeur/30, SpringLayout.EAST, terrain);
		plateau.add(tabJoueur[1]);

		tabJoueur[2] = new PanJoueur(rotation[2]  ,largeur,hauteur);
		tabJoueur[2].setBorder(new LineBorder(new Color(255, 0, 255), 2));
		spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[2], 10, SpringLayout.SOUTH, terrain);
		spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[2], largeur/30, SpringLayout.WEST, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[2], 90, SpringLayout.SOUTH, terrain);
		spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[2], largeur/5, SpringLayout.WEST, terrain);

		plateau.add(tabJoueur[2]);

		tabJoueur[3] = new PanJoueur(rotation[3]  ,largeur,hauteur);
		tabJoueur[3].setBorder(new LineBorder(Color.BLUE, 2));
		spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[3], 10, SpringLayout.SOUTH, terrain);
		spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[3], -largeur/5, SpringLayout.EAST, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[3], 90, SpringLayout.SOUTH, terrain);
		spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[3], -largeur/30, SpringLayout.EAST, terrain);
		plateau.add(tabJoueur[3]);

		tabJoueur[4] = new PanJoueur(rotation[5]  ,largeur,hauteur);
		tabJoueur[4].setBorder(new LineBorder(Color.PINK, 2));
		spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[4], 200, SpringLayout.NORTH, plateau);
		spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[4], -260, SpringLayout.WEST, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[4], 450, SpringLayout.NORTH, plateau);
		spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[4], -10, SpringLayout.WEST, terrain);
		plateau.add(tabJoueur[4]);

		tabJoueur[5] = new PanJoueur(rotation[4],largeur,hauteur);
		tabJoueur[5].setBorder(new LineBorder(Color.GREEN, 2));
		spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[5], 0, SpringLayout.NORTH, tabJoueur[4]);
		spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[5], 10, SpringLayout.EAST, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[5], 0, SpringLayout.SOUTH, tabJoueur[4]);
		spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[5], 260, SpringLayout.EAST, terrain);
		plateau.add(tabJoueur[5]);

		plateau.add(new JLabel(new ImageIcon(new ImageIcon("Images/fond.jpg").getImage().getScaledInstance(largeur, hauteur, Image.SCALE_DEFAULT))));

	}
}
