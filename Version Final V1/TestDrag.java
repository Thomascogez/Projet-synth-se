import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.*;

public class TestDrag  extends JFrame implements ActionListener{
	Image[] image;
	JButton[] reset;
	private JButton btnFin;
	JLabel[] picRobot1;
	JLabel[] picRobot2;
	JLabel[] picCarte;
	public TestDrag(){
		image =new Image[6];
		ImageIcon icon = new ImageIcon("Images/cartes.png");
		for (int i = 0;i<image.length ; i++) {
			image[i] = icon.getImage();
			image[i] = createImage(new FilteredImageSource(image[i].getSource(),
        // 50 d'écart entre chaques images
				new CropImageFilter(50*i, 50*1, 50, 50)));
		}

		picRobot1 = new JLabel[3];
		picRobot2 = new JLabel[3];
		picCarte  = new JLabel[13];
		picCarte[0]  = new JLabel(new ImageIcon(image[0]));
		picCarte[1]  = new JLabel(new ImageIcon(image[0]));
		picCarte[2]  = new JLabel(new ImageIcon(image[1]));
		picCarte[3]  = new JLabel(new ImageIcon(image[2]));
		picCarte[4]  = new JLabel(new ImageIcon(image[2]));
		picCarte[5]  = new JLabel(new ImageIcon(image[2]));
		picCarte[6]  = new JLabel(new ImageIcon(image[3]));
		picCarte[7]  = new JLabel(new ImageIcon(image[3]));
		picCarte[8]  = new JLabel(new ImageIcon(image[3]));
		picCarte[9]  = new JLabel(new ImageIcon(image[4]));
		picCarte[10]  = new JLabel(new ImageIcon(image[4]));
		picCarte[11]  = new JLabel(new ImageIcon(image[5]));
		picCarte[12]  = new JLabel(new ImageIcon(image[5]));
		
		 MouseListener ml = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
            
                JComponent jc = (JComponent)e.getSource();
                TransferHandler th = jc.getTransferHandler();
                th.exportAsDrag(jc, e, TransferHandler.COPY);
                jc.setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };

        JPanel panGauche = new JPanel();
        panGauche.setLayout(new GridLayout(2,3));
        reset = new JButton[6];
        for (int i=0; i<reset.length; i++ ) {
        	reset[i] = new JButton("X");
        	reset[i].addActionListener(this);
        	panGauche.add(reset[i]);
        }
        add(panGauche,BorderLayout.WEST);

        JPanel panCentre = new JPanel();
        panCentre.setLayout(new GridLayout(2,1));

        JPanel panProgra = new JPanel();
        for (int i = 0;i<picRobot1.length ; i++) {
        	picRobot1[i]  = new JLabel(new ImageIcon("Images/rouge.png"));
			//picRobot1[i].addMouseListener(ml);
        	picRobot1[i].setTransferHandler(new TransferHandler("icon"));
        	panProgra.add(picRobot1[i]);
		}
		panProgra.setBackground(new Color(130,130,130));
		panProgra.setEnabled(false);
		panProgra.add(Box.createHorizontalStrut(100));

		for (int i = 0;i<picRobot1.length ; i++) {
        	picRobot2[i]  = new JLabel(new ImageIcon("Images/rouge.png"));
			//picRobot2[i].addMouseListener(ml);
        	picRobot2[i].setTransferHandler(new TransferHandler("icon"));
        	panProgra.add(picRobot2[i]);
		}
        JPanel panCarte = new JPanel();
        panProgra.setBackground(new Color(130,130,130));
        for (int i = 0; i<picCarte.length ;i++ ) {
        	picCarte[i].addMouseListener(ml);
        	picCarte[i].setTransferHandler(new TransferHandler("icon"));
        	panCarte.add(picCarte[i]);
        }
        btnFin = new JButton("Fin Tour");
	  	btnFin.addActionListener(this);
	  	this.add(btnFin, BorderLayout.EAST);

        panCentre.add(panProgra);
        panCentre.add(panCarte);
        add(panCentre);
        setSize(1000,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}

	public static void main(String[] args){
		new TestDrag();
	}

	public void actionPerformed(ActionEvent e){
		for (int i=0; i<reset.length; i++ ) {
        	if (e.getSource()==reset[i]) {
        		Icon  image = null;
        		if (i<3) { 
        			image = picRobot1[i].getIcon();
        			picRobot1[i].setIcon(new ImageIcon("Images/rouge.png"));

        		}
        		else     { 
        			image = picRobot2[i-3].getIcon();
        			picRobot2[i-3].setIcon(new ImageIcon("Images/rouge.png"));
        		}
        		
        		for (int j=0; j<picCarte.length; j++ ) {
        			if (image == picCarte[j].getIcon()) {picCarte[j].setVisible(true);}
        		}
        	}
        }
        if (e.getSource()==btnFin) {
			//this.frame.finTour();
			System.out.println ( "Fin" );
		}
	}
	
}