import javax.swing.*;
import java.awt.*;

public class Main {
    /*
    Features!
    Tell how to care for plants:
        Soil type
        Watering
        Sunlight
        If plant is healthy or not
        Animals/pollinators
        Other factors?
    Tell if plant is harmful
     */

    public static void initializeJFrame(JFrame jf){
        jf.getContentPane().setBackground(Color.black);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(800, 600);
        jf.setLocationRelativeTo(null);
        jf.setTitle("GWC Challenge");
        jf.setVisible(true);
    }

    public static void main(String [] args){

        JFrame jf = new JFrame();
        initializeJFrame(jf);

        Layout obj = new Layout();
        jf.add(obj);

    }
}
