import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PanAction extends JFrame {
	
		
	public PanAction(){
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("Images/tableau_prog.jpg"));
		this.add(lblNewLabel, BorderLayout.NORTH);
	}

	public static void main(String[] args){
		new PanAction();
	}

}
