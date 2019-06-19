//package test;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.image.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * ImageCrop
 */
public class ImageCrop extends JFrame {
    Image image;

    Insets insets;

    public ImageCrop() {
        super();
        ImageIcon icon = new ImageIcon("Images/cartes.png");
        image = icon.getImage();
        image = createImage(new FilteredImageSource(image.getSource(),
        // 50 d'écart entre chaques images
        new CropImageFilter(50, 50, 50, 50)));
    }


    public void paint(Graphics g) {
        super.paint(g);
        if (insets == null) {
            insets = getInsets();
        }
        g.drawImage(image, insets.left, insets.top, this);
    }

    public static void main(String args[]) {
        JFrame f = new ImageCrop();
        f.setSize(200, 200);
        f.setVisible(true);
    }
}
