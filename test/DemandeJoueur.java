import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Toolkit;

public class DemandeJoueur extends JFrame implements ActionListener
{
	//private IHMGUI ihm;
	private SpinnerModel spinNbJ;
	private JSpinner spinner;
	private JPanel panHaut, panBas;
	private JButton bOk, bCancel;

	public DemandeJoueur(/*IHMGUI ihm*/)
	{
		this.setSize(320,60);
		//this.ihm = ihm;
		this.setLocationRelativeTo(null);
		this.spinNbJ = new SpinnerNumberModel(2,2,6,1);
		this.setUndecorated(true);
		this.spinner = new JSpinner(this.spinNbJ);   
		this.spinner.setBounds(100,100,50,30);  

		this.panHaut = new JPanel();
		this.panBas  = new JPanel();
		this.bOk=new JButton("Valider");
		DemandeJoueur. setStyleBtnAction(this.bOk);
		this.bOk.addActionListener(this);
		this.bCancel=new JButton("Quitter");
		DemandeJoueur. setStyleBtnAction(this.bCancel);
		this.bCancel.addActionListener(this);

		this.panHaut.setLayout(new GridLayout(1,2));
		this.panHaut.setBackground(new Color(196, 191, 187));
		this.panBas.setBackground(new Color(196, 191, 187));
		//this.panBas.setLayout(new GridLayout(1,2));

		JLabel lbl = new JLabel("Nombre de joueurs : ");
		this.panHaut.add(lbl);
		this.panHaut.add(this.spinner);

		this.panBas.add(this.bOk);
		this.panBas.add(Box.createHorizontalStrut(1));
		this.panBas.add(this.bCancel);

		this.add(this.panHaut,BorderLayout.NORTH);
		this.add(this.panBas,BorderLayout.SOUTH);    
    
    	this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==this.bCancel)
			this.dispose();
		if (e.getSource()==this.bOk)
		{	
			this.dispose();
			//this.ihm.setNbJ(Integer.valueOf(this.spinner.getValue().toString()));	
		}
	}

	public static void setStyleBtnAction(JButton btn)
	{
		btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn.setBorderPainted(false);
		btn.setFocusable(false);
		btn.setBackground(new Color(181, 55, 56));
		btn.setForeground(new Color(235, 235, 235));
		btn.setFont(new Font("Helvetica", Font.BOLD, 15));
	}

	public static void main(String[] args){
		new DemandeJoueur();
	}
}