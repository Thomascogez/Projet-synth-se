import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class PanJoueur extends JPanel{
	private PanAction action;
	private int nbJoueur;
	private int x;
	// Constructor
	public PanJoueur(int nbJoueur,int x, IHMLauncheur frame){
		this.x = x;
		this.setBackground(new Color(125,125,125));
		this.nbJoueur =nbJoueur;
		action = new PanAction(this.nbJoueur, frame,x);
		affichage();
	}

	public void affichage(){
		Image[] program =  action.getProgram();
		this.add(new JLabel(new ImageIcon(new ImageIcon("Images/R1.png").getImage().getScaledInstance(x/100,x/100 , Image.SCALE_SMOOTH))));
		for (int i=0;i<3 ;i++) {
			this.add(new JLabel(new ImageIcon(new ImageIcon(program[i]).getImage().getScaledInstance(x/100,x/100 , Image.SCALE_SMOOTH))));
		}
		this.add(new JLabel(new ImageIcon(new ImageIcon("Images/R2.png").getImage().getScaledInstance(x/100,x/100 , Image.SCALE_SMOOTH))));
		for (int i=3;i<6 ;i++) {
			this.add(new JLabel(new ImageIcon(new ImageIcon(program[i]).getImage().getScaledInstance(x/100,x/100 , Image.SCALE_SMOOTH))));
		}
	}

	public PanAction getPanAction(){return action;}

	public void majFinTour(){
		this.removeAll();
		affichage();
		this.revalidate();
		this.repaint();
	}

}
