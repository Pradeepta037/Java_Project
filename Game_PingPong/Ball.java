import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
    private int x, y, diameter, xVelocity, yVelocity;
    private Color color;

    public Ball(int x, int y, int diameter, int xVelocity, int yVelocity, Color color) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.color = color;
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    public void checkCollision(Rectangle bounds) {
        if (x <= bounds.x || x + diameter >= bounds.width) {
            xVelocity = -xVelocity;
        }
        if (y <= bounds.y || y + diameter >= bounds.height) {
            yVelocity = -yVelocity;
        }
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, diameter, diameter);
    }

    // Setter methods for xVelocity and yVelocity
    public void setXVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setYVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }
}
