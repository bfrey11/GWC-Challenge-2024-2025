import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Layout extends JPanel implements ActionListener {
    public Layout() {

    }

    @Override
    public void paintComponent(Graphics g) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
