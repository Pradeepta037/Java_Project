import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle {
    private int x, y;
    private Color color;
    private boolean upPressed, downPressed;

    public Paddle(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void move() {
        if (upPressed && y > 0) y -= PongGame.getPaddleSpeed();
        if (downPressed && y < PongGame.getHeight() - PongGame.getPaddleHeight()) y += PongGame.getPaddleSpeed();
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, PongGame.getPaddleWidth(), PongGame.getPaddleHeight());
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (x > PongGame.getWidth() / 2) upPressed = true;
                break;
            case KeyEvent.VK_DOWN:
                if (x > PongGame.getWidth() / 2) downPressed = true;
                break;
            case KeyEvent.VK_W:
                if (x < PongGame.getWidth() / 2) upPressed = true;
                break;
            case KeyEvent.VK_S:
                if (x < PongGame.getWidth() / 2) downPressed = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                upPressed = false;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = false;
                break;
            case KeyEvent.VK_W:
                upPressed = false;
                break;
            case KeyEvent.VK_S:
                downPressed = false;
                break;
        }
    }

    // Getter methods for x and y
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
