import java.awt.*;
import java.awt.event.*;

import static constants.Constants.*;

public class Ball {
    double x, y;
    double dx, dy;

    public Ball() {
        this.x = App.player.x + PLAYER_WIDTH / 2 - BALL_SIZE / 2;
        this.y = App.player.y - BALL_SIZE / 2;
        final double angle = Math.random() * (BALL_ANGLE_MAX - BALL_ANGLE_MIN) + BALL_ANGLE_MIN;
        this.dx = Math.cos(angle);
        this.dy = -Math.sin(angle);
    }

    public void move() {
        final int speed = Keyboard.isKeyPressed(KeyEvent.VK_UP) ? BALL_SPEED_MAX : BALL_SPEED_MIN;
        for (int i = 0; i < speed; i++) {
            moveOne();
        }
    }

    public void moveOne() {
        if (this.x < 0 || SCREEN_WIDTH < this.x + BALL_SIZE) {
            this.dx *= -1;
        }
        if (this.y < 0) {
            this.dy *= -1;
        }

        // blocks との衝突判定　Blocksでdx/dyをいじる
        App.blocks.update(this);

        // player との衝突判定
        if (
            App.player.x < this.x + BALL_SIZE / 2 &&
            this.x + BALL_SIZE / 2 < App.player.x + PLAYER_WIDTH &&
            App.player.y < this.y + BALL_SIZE / 2
        ) {
            double angle = (this.x + BALL_SIZE / 2 - App.player.x) / PLAYER_WIDTH * (BALL_ANGLE_MAX - BALL_ANGLE_MIN) + BALL_ANGLE_MIN;
            this.dx = - Math.cos(angle);
            this.dy = - Math.sin(angle);
        }

        this.x += this.dx;
        this.y += this.dy;

        if (SCREEN_HEIGHT - BOTTOM_MARGIN + 10 < this.y + BALL_SIZE) {
            App.gameScreen = GameScreenEnum.GAMEOVER;
        }

    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillOval((int)Math.round(this.x), (int)Math.round(this.y), BALL_SIZE, BALL_SIZE);
    }

}
