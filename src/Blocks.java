import java.awt.*;
import java.util.ArrayList;

import static constants.Constants.*;

public class Blocks {
    public ArrayList<Block> blocks;
    
    Blocks() {
        blocks = new ArrayList<Block>();
        int colCount = (SCREEN_WIDTH - 2 * SIDE_MARGIN) / (BLOCK_WIDTH + 2 * BLOCK_MARGIN);
        int startX = (SCREEN_WIDTH - (BLOCK_WIDTH + 2 * BLOCK_MARGIN) * colCount) / 2;
        int startY = TOP_MARGIN;

        for (int h = 0; h < 20; h++) {
            for (int w = 0; w < colCount; w++) {
                int x = startX + (BLOCK_WIDTH + 2 * BLOCK_MARGIN) * w;
                int y = startY + (BLOCK_HEIGHT + 2 * BLOCK_MARGIN) * h;
                Color color = new Color(255 - 10 * h, 0, 0);
                blocks.add(new Block(x, y, color));
            }
        }
    }

    public void update(Ball ball) {
        ArrayList<Block> newBlocks = new ArrayList<>();
        for (Block block: blocks) {
            if (!block.delete(ball)) {
                newBlocks.add(block);
            }
        }
        if (newBlocks.size() == 0) {
            App.gameScreen = GameScreenEnum.GAMECLEAR;
        }
        blocks = newBlocks;
    }

    public void draw(Graphics gra) {
        for (Block block: this.blocks) {
            block.draw(gra);
        }
    }
}
