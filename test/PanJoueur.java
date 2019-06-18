import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PanJoueur extends JPanel{
	private double rotation;
	// Constructor
	public PanJoueur(double rotation){
		//this.setPreferredSize(new Dimension(320, 100));
		this.rotation = rotation;
		this.add(new JLabel(new ImageIcon("Images/fond.jpg")));
	}

	/* @Override
	public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int w2 = getWidth() / 2;
        g2.drawString("Hello World", 2, 12);
        int h2 = getHeight() / 2;
        g2d.rotate(this.rotation , w2, h2);
        super.paintComponent(g);
    }*/
	
}