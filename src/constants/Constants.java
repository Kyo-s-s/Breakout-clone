package constants;
public class Constants {
    private Constants() {}

    public static final boolean DEBUG = false;
    public static final int SCREEN_WIDTH = 500;
    public static final int SCREEN_HEIGHT = 700;
    public static final int FPS = 30;

    public static final int TOP_MARGIN = 50;
    public static final int BOTTOM_MARGIN = 100;
    public static final int SIDE_MARGIN = 50;

    public static final int PLAYER_WIDTH = 100;
    public static final int PLAYER_HEIGHT = 10;
    public static final int PLAYER_SPEED = 15;

    public static final int BLOCK_WIDTH = 50;
    public static final int BLOCK_HEIGHT = 20;
    public static final int BLOCK_MARGIN = 1; // 上下左右のmargin

    public static final int BALL_SIZE = 10;
    public static final int BALL_SPEED_MIN = 8;
    public static final int BALL_SPEED_MAX = 20;

    public static final double BALL_ANGLE_MIN = Math.PI / 6;
    public static final double BALL_ANGLE_MAX = Math.PI * 5 / 6;
}
