import java.awt.*;

public class Brick {

    public static final int WIDTH = 80;
    public static final int HEIGHT = 30;

    private final int x, y;

    public Brick(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}
