import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Layout extends JPanel implements ActionListener {
    public Layout() {

    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.decode("#ffffff"));
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString("(App Name...)",25,25);
        g.fillRect(30,50,300,480);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
