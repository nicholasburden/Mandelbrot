import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class CreateFrame {
    static int w= 1200; //Set dimensions of Frame
    static int h = 680;
    static JFrame frame = new JFrame("The Mandelbrot Set"); //Make Frame
    static int type = BufferedImage.TYPE_INT_RGB; //Initialise image
    public BufferedImage image = new BufferedImage(w, h, type); //New image
    public void constructFrame(){ //Make frame with drawn pixels
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new JLabel(new ImageIcon(image)));
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        changeColour();
    }
    public void changeColour(){

        while(true){

            for(int i = 0; i <= image.getHeight()-1; i++){
                for(int j = 0; j <= image.getWidth() -1; j++){
                    Color c = new Color(image.getRGB(j, i));
                    int red = c.getRed();
                    int green = c.getGreen();
                    int blue = c.getBlue();
                    if(!(red==0 && blue ==0 && green ==0)&& !(image.getRGB(j,i) == -16777196)){
                        image.setRGB(j, i, image.getRGB(j, i) + 12);
                    }


                }
            }
            frame.getContentPane().add(new JLabel(new ImageIcon(image)));
            frame.setVisible(true);

        }
    }
}
