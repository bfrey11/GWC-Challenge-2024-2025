import javax.swing.*;
import java.awt.*;

public class Main {
    /*
    Features!
    Sustainability Score
        plant benefits
    Tell how to care for plants:
        Soil type
        Watering: Water once a week
        Sunlight
        If plant is healthy or not
        Animals/pollinators
        Other factors?
    Tell if plant is harmful
    Plant identification
    Growing Timeline/lifespan

    Tomatoes need 6-8 hours of sunlight per day.
    Tomatoes need to be watered consistently, avoiding overhead watering to avoid fungal diseases
    */


    public static void initializeJFrame(JFrame jf){
        jf.getContentPane().setBackground(Color.decode("#004400"));
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

        //PlantLogic logic = new PlantLogic(obj);

    }
}
