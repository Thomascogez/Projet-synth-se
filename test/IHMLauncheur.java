import javax.swing.*;
import java.awt.*;

import javax.swing.border.*;
import java.awt.event.*;

public class IHMLauncheur extends JFrame {


	public static void main(String[] args) {

		IHMLauncheur frame = new IHMLauncheur();
		frame.setVisible(true);
	}

	public IHMLauncheur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,800);
		this.setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("D:/coursIUT/IUT/test/Images/programme.png"));
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
		terrain.add(new JLabel(new ImageIcon(new ImageIcon("D:/coursIUT/IUT/projetSynthese/Images/board1.jpg").getImage().getScaledInstance(620, 400, Image.SCALE_DEFAULT))));
		
		JPanel joueur_1 = new JPanel();
		joueur_1.setBorder(new LineBorder(Color.RED, 2));
		spGeneral.putConstraint(SpringLayout.NORTH, joueur_1, -96, SpringLayout.NORTH, terrain);
		spGeneral.putConstraint(SpringLayout.WEST, joueur_1, 0, SpringLayout.WEST, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, joueur_1, -10, SpringLayout.NORTH, terrain);
		spGeneral.putConstraint(SpringLayout.EAST, joueur_1, 400, SpringLayout.WEST, plateau);
		plateau.add(joueur_1);
		
		JPanel joueur_2 = new JPanel();
		joueur_2.setBorder(new LineBorder(Color.YELLOW, 2));
		spGeneral.putConstraint(SpringLayout.NORTH, joueur_2, -96, SpringLayout.NORTH, terrain);
		spGeneral.putConstraint(SpringLayout.WEST, joueur_2, 120, SpringLayout.EAST, joueur_1);
		spGeneral.putConstraint(SpringLayout.SOUTH, joueur_2, -10, SpringLayout.NORTH, terrain);
		spGeneral.putConstraint(SpringLayout.EAST, joueur_2, -200, SpringLayout.EAST, plateau);
		plateau.add(joueur_2);
		
		JPanel joueur_3 = new JPanel();
		joueur_3.setBorder(new LineBorder(new Color(255, 0, 255), 2));
		spGeneral.putConstraint(SpringLayout.NORTH, joueur_3, 6, SpringLayout.SOUTH, terrain);
		spGeneral.putConstraint(SpringLayout.WEST, joueur_3, 150, SpringLayout.WEST, plateau);
		spGeneral.putConstraint(SpringLayout.SOUTH, joueur_3, 96, SpringLayout.SOUTH, terrain);
		plateau.add(joueur_3);
		
		JPanel joueur_4 = new JPanel();
		joueur_4.setBorder(new LineBorder(Color.BLUE, 2));
		spGeneral.putConstraint(SpringLayout.WEST, joueur_4, 520, SpringLayout.WEST, plateau);
		spGeneral.putConstraint(SpringLayout.EAST, joueur_3, -120, SpringLayout.WEST, joueur_4);
		spGeneral.putConstraint(SpringLayout.NORTH, joueur_4, 6, SpringLayout.SOUTH, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, joueur_4, 0, SpringLayout.SOUTH, joueur_3);
		spGeneral.putConstraint(SpringLayout.EAST, joueur_4, 0, SpringLayout.EAST, terrain);
		plateau.add(joueur_4);
		
		JPanel joueur_5 = new JPanel();
		joueur_5.setBorder(new LineBorder(Color.PINK, 2));
		spGeneral.putConstraint(SpringLayout.NORTH, joueur_5, 209, SpringLayout.NORTH, plateau);
		spGeneral.putConstraint(SpringLayout.WEST, joueur_5, -123, SpringLayout.WEST, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, joueur_5, 431, SpringLayout.NORTH, plateau);
		spGeneral.putConstraint(SpringLayout.EAST, joueur_5, -7, SpringLayout.WEST, terrain);
		plateau.add(joueur_5);
		
		JPanel joueur_6 = new JPanel();
		joueur_6.setBorder(new LineBorder(Color.GREEN, 2));
		spGeneral.putConstraint(SpringLayout.NORTH, joueur_6, 0, SpringLayout.NORTH, joueur_5);
		spGeneral.putConstraint(SpringLayout.WEST, joueur_6, 21, SpringLayout.EAST, terrain);
		spGeneral.putConstraint(SpringLayout.SOUTH, joueur_6, 0, SpringLayout.SOUTH, joueur_5);
		spGeneral.putConstraint(SpringLayout.EAST, joueur_6, 137, SpringLayout.EAST, terrain);
		plateau.add(joueur_6);
		
		plateau.add(new JLabel(new ImageIcon(new ImageIcon("D:/coursIUT/IUT/test/Images/fond.jpg").getImage().getScaledInstance(1000, 800, Image.SCALE_DEFAULT))));

	}
}
