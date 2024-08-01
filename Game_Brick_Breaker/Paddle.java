import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle {

    public static final int WIDTH = 100;
    private static final int HEIGHT = 20;
    private static final int SPEED = 5;

    public int x, y;
    private boolean left, right;

    public Paddle() {
        x = 350;
        y = 550;
    }

    public void move() {
        if (left && x > 0) x -= SPEED;
        if (right && x < 700) x += SPEED;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) left = true;
        if (key == KeyEvent.VK_RIGHT) right = true;
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) left = false;
        if (key == KeyEvent.VK_RIGHT) right = false;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}
