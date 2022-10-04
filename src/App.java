import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class App {

    public static GameFrame gameFrame;
    public static boolean loop;
    public static GameScreenEnum gameScreen;
    
    private static ArrayList<Block> blocks = new ArrayList<Block>();

    public static void main(String[] args) throws Exception {

        gameFrame = new GameFrame();
        loop = true;
        gameScreen = GameScreenEnum.START;

        Graphics gra = gameFrame.panel.image.getGraphics();

        gameFrame.panel.draw();

        int fps = 0;
        long startTime, fpsTime = 0;

        while (loop) {
            startTime = System.currentTimeMillis();
            if (Constants.DEBUG && startTime - fpsTime >= 1000) {
                fpsTime = startTime;
                System.out.println("FPS: " + fps);
                fps = 0;
            }
            fps++;

            gra.setColor(Color.white);
            gra.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

            switch (gameScreen) {
                case START:
                    start();
                    break;
                case GAME:
                    game();
                    break;
                case GAMEOVER:
                    gameOver();
                    break;
            }
            gameFrame.panel.draw();

            try {
                long runTime = System.currentTimeMillis() - startTime;
                if (runTime < 1000 / Constants.FPS) {
                    Thread.sleep(1000 / Constants.FPS - runTime);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void start() {
        Graphics gra = gameFrame.panel.image.getGraphics();
        gra.setColor(Color.black);
        Font font = new Font("SansSerif", Font.PLAIN, 50);
        gra.setFont(font);
        FontMetrics metrics = gra.getFontMetrics(font);
        gra.drawString("Breakout clone", 250 - metrics.stringWidth("Breakout clone") / 2, 200);
        font = new Font("SansSerif", Font.PLAIN, 20);
        gra.setFont(font);
        metrics = gra.getFontMetrics(font);
        gra.drawString("Press enter to start", 250 - metrics.stringWidth("Press enter to start") / 2, 300);
        if (Keyboard.isKeyPressed(KeyEvent.VK_ENTER)) {
            startGame();
        }
    }

    public static void startGame() {
        gameScreen = GameScreenEnum.GAME;
        blocks.clear();

        for (int x = Constants.SIDE_MARGIN; x + Constants.BLOCK_WIDTH <= Constants.SCREEN_WIDTH - Constants.SIDE_MARGIN; x += Constants.BLOCK_WIDTH) {
            for (int y = Constants.TOP_MARGIN; y + Constants.BLOCK_HEIGHT <= Constants.SCREEN_HEIGHT - 200; y += Constants.BLOCK_HEIGHT) {
                blocks.add(new Block(x, y, Color.red));
            }
        }
    }

    public static void game() {
        Graphics gra = gameFrame.panel.image.getGraphics();
        for (Block block: blocks) {
            block.draw(gra);
        }
    }

    public static void gameOver() {

    }

}
