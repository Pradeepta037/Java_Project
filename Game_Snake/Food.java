import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class Food {
    private Point location;
    private static final int SIZE = 10;

    public Food(int boardWidth, int boardHeight) {
        Random rand = new Random();
        location = new Point(rand.nextInt(boardWidth / SIZE) * SIZE, 
                             rand.nextInt(boardHeight / SIZE) * SIZE);
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(location.x, location.y, SIZE, SIZE);
    }
}
