import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

public class Layout extends JPanel implements ActionListener {
    private String plantName;
    private Timer timer;
    private String[] info;
    private HashMap<String,String[]> dataMap;
    public Layout() {
        timer = new Timer(25,this);
        timer.start();
        timer.addActionListener(this);
    }

    public void setInfo(String[] info) {
        this.info = info;
        System.out.println(info);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.decode("#ffffff"));
        g.setFont(new Font("Helvetica", Font.BOLD, 25));
        g.drawString("PlantByte",25,25);
        g.fillRect(30,50,300,480);

        g.drawString("Name: " + plantName,400,75);
        g.drawString("Benefits: " + info[0],400, 125);
        g.drawString("Water: " + info[1],400,175);
        g.drawString("Sunlight: " + info[2],400,225);
        g.drawString("Harm: " + info[3],400,275);
        g.drawString("Health: " + info[4],400,325);
        g.drawString("Sustainability: " + info[5], 400, 375);
        g.drawString("Soil: " + info[6], 400, 425);
        g.drawString("Pollinators: " + info[7], 400, 475);
        //System.out.println(plantName);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void setPlantName(String name) {
        plantName = name;
    }
}
