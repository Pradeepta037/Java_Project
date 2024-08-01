import java.awt.*;

public class Ball {

    private static final int DIAMETER = 20;
    private static final int SPEED = 2;

    private int x, y;
    private int xSpeed, ySpeed;

    public Ball() {
        x = 390;
        y = 300;
        xSpeed = SPEED;
        ySpeed = -SPEED;
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;

        if (x < 0 || x > 780) xSpeed = -xSpeed;
        if (y < 0) ySpeed = -ySpeed;
        if (y > 580) {
            x = 390;
            y = 300;
            xSpeed = SPEED;
            ySpeed = -SPEED;
        }
    }

    public void checkCollision(Paddle paddle) {
        if (x > paddle.x && x < paddle.x + Paddle.WIDTH && y + DIAMETER > paddle.y) {
            ySpeed = -ySpeed;
        }
    }

    public void checkCollision(Brick[][] bricks) {
        for (int row = 0; row < bricks.length; row++) {
            for (int col = 0; col < bricks[row].length; col++) {
                Brick brick = bricks[row][col];
                if (brick != null && x > brick.getX() && x < brick.getX() + Brick.WIDTH
                        && y < brick.getY() + Brick.HEIGHT && y + DIAMETER > brick.getY()) {
                    ySpeed = -ySpeed;
                    bricks[row][col] = null; // Remove the brick
                }
            }
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }
}
