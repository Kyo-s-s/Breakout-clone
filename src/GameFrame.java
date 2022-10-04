import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import static constants.Constants.*;

public class GameFrame extends JFrame {
    public GamePanel panel;

    public GameFrame() {
        
        this.panel = new GamePanel();
        this.add(panel);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                App.loop = true;
            }
        });

        this.addKeyListener(new Keyboard());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Breakout clone");
        this.setSize(SCREEN_WIDTH + 15, SCREEN_HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
