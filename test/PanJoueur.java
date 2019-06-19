import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class PanJoueur extends JPanel{
	private double rotation;
	private JLabel lblprog;
	private int x;
	// Constructor
	public PanJoueur(double rotation,int x, int y){
		//this.setSize(x,y);
		this.rotation = rotation;
		lblprog = new JLabel(new ImageIcon(new ImageIcon("Images/tableau_prog.jpg").getImage().getScaledInstance(x/5-x/28, 40, Image.SCALE_SMOOTH)));
		this.add(lblprog);
		//this.add(new JLabel("TEST"));
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
