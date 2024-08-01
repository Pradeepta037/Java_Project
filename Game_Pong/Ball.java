import java.awt.*;

public class Ball {
    private int x, y;
    private int dx, dy;
    private Color color;

    public Ball(int x, int y, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.color = Color.WHITE;
    }

    public void move() {
        x += dx;
        y += dy;

        if (y < 0 || y > PongGame.getHeight() - PongGame.getBallSize()) dy = -dy;
    }

    public void checkCollision(Paddle paddle) {
        if (new Rectangle(x, y, PongGame.getBallSize(), PongGame.getBallSize())
                .intersects(new Rectangle(paddle.getX(), paddle.getY(), PongGame.getPaddleWidth(), PongGame.getPaddleHeight()))) {
            dx = -dx;
        }
    }

    public void reset(int x, int y) {
        this.x = x;
        this.y = y;
        dx = -dx;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, PongGame.getBallSize(), PongGame.getBallSize());
    }

    public int getX() {
        return x;
    }
}
