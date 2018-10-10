import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.security.acl.LastOwnerException;

public class Rotation extends JPanel {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new Rotation());
        frame.setSize(400,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    int increamenter = 0;
    public void paintComponent(Graphics g){

        BufferedImage myimage = LoadImage("C:\\Users\\Anichur\\Desktop\\Apple.jpg");
        AffineTransform transform = AffineTransform.getTranslateInstance(100,100);
        transform.rotate(Math.toRadians(increamenter++),myimage.getWidth()/2,myimage.getHeight()/2);
        Graphics2D graphics2D = (Graphics2D) g;
        transform.scale(2,2);
        graphics2D.drawImage(myimage,transform,null);
        repaint();
    }

    BufferedImage LoadImage(String Filename){

        BufferedImage image = null;

        try{
             image = ImageIO.read(new File(Filename));
        }catch (Exception e){}

        return image;
    }
}
