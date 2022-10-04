import java.awt.*;

import static constants.Constants.*;

public class Ball {
    double x, y;
    double dx, dy;

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

        // blocks との衝突判定　Blocksでdx/dyをいじる
        App.blocks.update(this);

        // player との衝突判定
        if (
            App.player.x < this.x + BALL_SIZE / 2 &&
            this.x + BALL_SIZE / 2 < App.player.x + PLAYER_WIDTH &&
            App.player.y < this.y + BALL_SIZE / 2
        ) {
            this.dy *= -1;  // TODO: 位置によって角度を変える
        }

        this.x += this.dx;
        this.y += this.dy;

        if (SCREEN_HEIGHT - BOTTOM_MARGIN + 20 < this.y + BALL_SIZE) {
            App.gameScreen = GameScreenEnum.GAMEOVER;
        }

    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillOval((int)Math.round(this.x), (int)Math.round(this.y), BALL_SIZE, BALL_SIZE);
    }

}
