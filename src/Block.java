import java.awt.*;

import static constants.Constants.*;

public class Block {
    public int x, y;
    public Color color;

    Block() {}
    Block(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public boolean delete(Ball ball) {
        if (
            this.x + BLOCK_MARGIN < ball.x + BALL_SIZE / 2 &&
            ball.x + BALL_SIZE / 2 < this.x + BLOCK_WIDTH - BLOCK_MARGIN &&
            this.y < ball.y + BALL_SIZE / 2 &&
            ball.y + BALL_SIZE / 2 < this.y + BLOCK_HEIGHT
        ) {
            ball.dy *= -1;
            return true;
        }

        if (
            this.y + BLOCK_MARGIN < ball.y + BALL_SIZE / 2 &&
            ball.y + BALL_SIZE / 2 < this.y + BLOCK_HEIGHT - BLOCK_MARGIN &&
            this.x < ball.x + BALL_SIZE / 2 &&
            ball.x + BALL_SIZE / 2 < this.x + BLOCK_WIDTH
        ) {
            ball.dx *= -1;
            return true;
        }

        return false;
    }

    public void draw(Graphics gra) {
        gra.setColor(this.color);
        gra.fillRect(this.x + BLOCK_MARGIN, this.y + BLOCK_MARGIN, 
                     BLOCK_WIDTH, BLOCK_HEIGHT);
    }
}
