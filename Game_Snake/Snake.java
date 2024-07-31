import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Point> body;
    private Direction direction;
    private static final int SIZE = 10;

    public Snake(int startX, int startY) {
        body = new LinkedList<>();
        body.add(new Point(startX, startY));
        direction = Direction.RIGHT;
    }

    public LinkedList<Point> getBody() {
        return body;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move() {
        Point head = body.getFirst();
        Point newHead = new Point(head);
        
        switch (direction) {
            case UP: newHead.translate(0, -SIZE); break;
            case DOWN: newHead.translate(0, SIZE); break;
            case LEFT: newHead.translate(-SIZE, 0); break;
            case RIGHT: newHead.translate(SIZE, 0); break;
        }
        
        body.addFirst(newHead);
        body.removeLast();
    }

    public void grow() {
        Point tail = body.getLast();
        body.addLast(new Point(tail));
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        for (Point p : body) {
            g.fillRect(p.x, p.y, SIZE, SIZE);
        }
    }
}
