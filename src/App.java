import java.awt.*;

public class App {

    public static GameFrame gameFrame;
    public static boolean loop;
    public static GameScreenEnum gameScreen;

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
                    break;
                case GAMEOVER:
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
        gra.drawString("Breakout clone", 250 - metrics.stringWidth("Breakout clone") / 2, 100);
    }    
    


}
