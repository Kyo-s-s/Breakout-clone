import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import static constants.Constants.*;

public class GamePanel extends JPanel {
    public BufferedImage image;

    public GamePanel() {
        image = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, this);
    }

    public void draw() {
        this.repaint();
    }
}
