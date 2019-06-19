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
		this.setSize(1000,800);
		this.setLocationRelativeTo(null);
		this.tabJoueur = new PanJoueur[6];
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("Images/programme.png"));
		panel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);

		JPanel plateau = new JPanel();
		contentPane.add(plateau, BorderLayout.CENTER);
		SpringLayout spGeneral = new SpringLayout();
		plateau.setLayout(spGeneral);

		JPanel terrain = new JPanel();
		spGeneral.putConstraint(SpringLayout.NORTH, terrain, 120, SpringLayout.NORTH, plateau);
		spGeneral.putConstraint(SpringLayout.WEST, terrain, 150, SpringLayout.WEST, plateau);
		spGeneral.putConstraint(SpringLayout.SOUTH, terrain, 520, SpringLayout.NORTH, plateau);
		spGeneral.putConstraint(SpringLayout.EAST, terrain, 770, SpringLayout.WEST, plateau);
		plateau.add(terrain);
		terrain.add(new JLabel(new ImageIcon(new ImageIcon("Images/board1.jpg").getImage().getScaledInstance(620, 400, Image.SCALE_DEFAULT))));

		JPanel joueur_1 = new JPanel();
		tabJoueur[0] = new PanJoueur(rotation[0]  /*,dim[0]*/);
		tabJoueur[0].setBorder(new LineBorder(Color.RED, 2));
		spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[0], -90, SpringLayout.NORTH, terrain);
		spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[0], 0, SpringLayout.WEST, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[0], -10, SpringLayout.NORTH, terrain);
		spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[0], 400, SpringLayout.WEST, plateau);
		plateau.add(tabJoueur[0]);

		tabJoueur[1] = new PanJoueur(rotation[1]  /*,dim[0]*/);
		tabJoueur[1].setBorder(new LineBorder(Color.YELLOW, 2));
		spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[1], -90, SpringLayout.NORTH, terrain);
		spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[1], 120, SpringLayout.EAST, tabJoueur[0]);
		spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[1], -10, SpringLayout.NORTH, terrain);
		spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[1], 0, SpringLayout.EAST, terrain);
		plateau.add(tabJoueur[1]);

		tabJoueur[2] = new PanJoueur(rotation[2]  /*,dim[0]*/);
		tabJoueur[2].setBorder(new LineBorder(new Color(255, 0, 255), 2));
		spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[2], 6, SpringLayout.SOUTH, terrain);
		spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[2], 150, SpringLayout.WEST, plateau);
		spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[2], 96, SpringLayout.SOUTH, terrain);
		plateau.add(tabJoueur[2]);

		tabJoueur[3] = new PanJoueur(rotation[3]  /*,dim[0]*/);
		tabJoueur[3].setBorder(new LineBorder(Color.BLUE, 2));
		spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[3], 520, SpringLayout.WEST, plateau);
		spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[2], -120, SpringLayout.WEST, tabJoueur[3]);
		spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[3], 6, SpringLayout.SOUTH, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[3], 0, SpringLayout.SOUTH, tabJoueur[2]);
		spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[3], 0, SpringLayout.EAST, terrain);
		plateau.add(tabJoueur[3]);

		tabJoueur[4] = new PanJoueur(rotation[5]  /*,dim[0]*/);
		tabJoueur[4].setBorder(new LineBorder(Color.PINK, 2));
		spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[4], 200, SpringLayout.NORTH, plateau);
		spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[4], -260, SpringLayout.WEST, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[4], 450, SpringLayout.NORTH, plateau);
		spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[4], -10, SpringLayout.WEST, terrain);
		plateau.add(tabJoueur[4]);

		tabJoueur[5] = new PanJoueur(rotation[4]/*dim[1]*/);
		tabJoueur[5].setBorder(new LineBorder(Color.GREEN, 2));
		spGeneral.putConstraint(SpringLayout.NORTH, tabJoueur[5], 0, SpringLayout.NORTH, tabJoueur[4]);
		spGeneral.putConstraint(SpringLayout.WEST, tabJoueur[5], 10, SpringLayout.EAST, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, tabJoueur[5], 0, SpringLayout.SOUTH, tabJoueur[4]);
		spGeneral.putConstraint(SpringLayout.EAST, tabJoueur[5], 260, SpringLayout.EAST, terrain);
		plateau.add(tabJoueur[5]);

		plateau.add(new JLabel(new ImageIcon(new ImageIcon("D:/coursIUT/IUT/test/Images/fond.jpg").getImage().getScaledInstance(1000, 800, Image.SCALE_DEFAULT))));

	}
}
