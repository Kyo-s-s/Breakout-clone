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

    public void draw(Graphics gra) {
        gra.setColor(this.color);
        gra.fillRect(this.x, this.y, BLOCK_WIDTH - 1, BLOCK_HEIGHT - 1);
    }
}
