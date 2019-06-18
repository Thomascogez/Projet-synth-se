import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TestIHMGUI extends JFrame{
	
	private PanelTerrain panTerrain;

	public TestIHMGUI(){
		this.setTitle( "twin tin bot" );
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 750);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		this.panTerrain = new PanelTerrain();
		this.add(this.panTerrain);
		this.setVisible(true);		
	}
	public static void main(String[] args){
		new TestIHMGUI();
	}	
}