import java.awt.*;

import static constants.Constants.*;

public class Ball {
    int x, y;
    int dx, dy;

    public Ball() {
        this.x = App.player.x + PLAYER_WIDTH / 2 - BALL_SIZE / 2;
        this.y = App.player.y - BALL_SIZE / 2;
        this.dx = -1;
        this.dy = -1;
    }

    public void move() {
        for (int i = 0; i < BALL_SPEED; i++) {
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

        // TODO: blocks との衝突判定
        // TODO: player との衝突判定

        this.x += this.dx;
        this.y += this.dy;

        if (SCREEN_HEIGHT - BOTTOM_MARGIN + 10 < this.y + BALL_SIZE) {
            App.gameScreen = GameScreenEnum.GAMEOVER;
        }

    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(this.x, this.y, BALL_SIZE, BALL_SIZE);
    }

}
