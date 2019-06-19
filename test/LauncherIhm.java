import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class LauncherIhm {

	private JFrame frame;


	public LauncherIhm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 515, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JButton btnNewButton = new JButton("Jouer !");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setOpaque(false);
		btnNewButton.setForeground(Color.ORANGE);
		btnNewButton.setBackground(new Color(0, 204, 204));
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 159, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -218, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -156, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton);
		
		JButton btnQuitter = new JButton("Quitter");
		springLayout.putConstraint(SpringLayout.WEST, btnQuitter, 159, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnQuitter, -156, SpringLayout.EAST, frame.getContentPane());
		btnQuitter.setBackground(new Color(255, 0, 0));
		frame.getContentPane().add(btnQuitter);
		
		JButton btnNewButton_1 = new JButton("Continuer");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 159, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -168, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -156, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnQuitter, 24, SpringLayout.SOUTH, btnNewButton_1);
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.setIcon(new ImageIcon("C:\\Users\\wedzy\\Desktop\\Projet-synth-se\\Images\\FondLauncheur.png"));
		springLayout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(label);
	}
}
