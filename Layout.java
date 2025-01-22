import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Layout extends JPanel implements ActionListener {
    private String plantName;
    private Timer timer;
    public Layout() {
        timer = new Timer(25,this);
        timer.start();
        timer.addActionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.decode("#ffffff"));
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString("(App Name)",25,25);
        g.fillRect(30,50,300,480);

        g.drawString("Name: " + plantName,400,75);
        System.out.println(plantName);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void setPlantName(String name) {
        plantName = name;
    }

    public String getPlantName() {return plantName;}
}
