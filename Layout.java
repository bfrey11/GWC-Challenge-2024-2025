import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Layout extends JPanel implements ActionListener {
    private String plantName;
    private Timer timer;
    private String[] info;
    private HashMap<String,String[]> dataMap;
    private String[] plants;
    private BufferedImage image;
    public Layout() {
        //constructor
        Dimension dim = new Dimension(800,600);

        this.setSize(dim);
        this.setBackground(Color.decode("#004400"));
        this.setLayout(null);
        this.setVisible(true);
        this.setFocusable(true);

        try {
            image = ImageIO.read(new File("tomato.jpg"));
            image = resizeImage(image,300,480);
        }
        catch(IOException e) {
            System.out.println(e);
        }

        plants = new String[3];
        plants[0] = "Tomatoes";
        plants[1] = "Aloe Vera";
        plants[2] = "Lavender";

        plantName = plants[(int)Math.floor((Math.random())*(plants.length))];

        timer = new Timer(25,this);
        timer.start();
        timer.addActionListener(this);
        dataMap = new HashMap<>();
        makeHash();
        plantName = "Tomatoes";
        info = dataMap.get(plantName);
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }

    public void setInfo(String[] info) {
        this.info = info;
    }

    public void makeHash() {
        try {
            Scanner scanner = new Scanner(new File("data.txt"));
            while(scanner.hasNext()) {
                parse(scanner.nextLine());
            }
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }

    public void parse(String line) {
        String[] data = new String[9];
        String name = line.substring(0,line.indexOf(" ")).replace("_"," ");
        line = line.substring(line.indexOf(" ")+1);
        for(int i=0; i<8; i++) {
            data[i] = line.substring(0,line.indexOf(" ")).replace("_"," ");
            line = line.substring(line.indexOf(" ")+1);
        }
        data[8] = line;
        dataMap.put(name,data);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
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
        g.drawString("Pollinators: " + info[8], 400, 475);

        g.drawImage(image, 30, 50, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void setPlantName(String name) {
        plantName = name;
    }

    @Override
    public void addNotify() {
        super.addNotify();
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyHandler());
    }

    public class KeyHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            String key = KeyEvent.getKeyText(e.getKeyCode());

            if (key.equals("Enter")&&plants!=null) {
                plantName = plants[(int)Math.floor((Math.random())*(plants.length))];
                info = dataMap.get(plantName);
                try {
                    image = ImageIO.read(new File(info[7]));
                    image = resizeImage(image,300,480);
                }
                catch(IOException i) {
                    System.out.println(i);
                }
            }
        }
    }
}
