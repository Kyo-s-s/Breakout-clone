import java.awt.*;
import java.awt.event.*;

import static constants.Constants.*;

public class Player {
    int x, y;

    public Player() {
        this.x = SCREEN_WIDTH / 2 - PLAYER_WIDTH / 2;
        this.y = SCREEN_HEIGHT - BOTTOM_MARGIN;
    }

    public void move() {
        if (Keyboard.isKeyPressed(KeyEvent.VK_LEFT) || Keyboard.isKeyPressed(KeyEvent.VK_H)) {
            this.x -= PLAYER_SPEED;
        }
        if (Keyboard.isKeyPressed(KeyEvent.VK_RIGHT) || Keyboard.isKeyPressed(KeyEvent.VK_L)) {
            this.x += PLAYER_SPEED;
        }
        if (this.x < 0) {
            this.x = 0;
        }
        if (SCREEN_WIDTH < this.x + PLAYER_WIDTH) {
            this.x = SCREEN_WIDTH - PLAYER_WIDTH;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(this.x, this.y, PLAYER_WIDTH, PLAYER_HEIGHT);
    }

}
