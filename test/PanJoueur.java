import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PanJoueur extends JPanel{
	private double rotation;
	// Constructor
	public PanJoueur(double rotation){
		this.setPreferredSize(new Dimension(320, 100));
		this.rotation = rotation;
		this.add(new JLabel(new ImageIcon("Images/fond.jpg")));
		this.add(new JLabel("test"));
		
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int x = this.getWidth()/2;
		int y = this.getHeight()/2;
		g2.rotate(rotation, x, y);
		super.paintComponent(g2);
    }
	
}