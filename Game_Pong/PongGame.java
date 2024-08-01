import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PongGame extends JPanel implements ActionListener, KeyListener {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    public static final int PADDLE_WIDTH = 10;
    public static final int PADDLE_HEIGHT = 100;
    public static final int BALL_SIZE = 20;
    public static final int PADDLE_SPEED = 5;
    public static final int BALL_SPEED_X = 4;
    public static final int BALL_SPEED_Y = 3;

    private Timer timer;
    private Paddle player1;
    private Paddle player2;
    private Ball ball;

    public PongGame() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(this);

        player1 = new Paddle(30, HEIGHT / 2 - PADDLE_HEIGHT / 2, Color.RED);
        player2 = new Paddle(WIDTH - 30 - PADDLE_WIDTH, HEIGHT / 2 - PADDLE_HEIGHT / 2, Color.BLUE);
        ball = new Ball(WIDTH / 2 - BALL_SIZE / 2, HEIGHT / 2 - BALL_SIZE / 2, BALL_SPEED_X, BALL_SPEED_Y);

        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ball.move();
        ball.checkCollision(player1);
        ball.checkCollision(player2);

        if (ball.getX() < 0 || ball.getX() > WIDTH - BALL_SIZE) {
            ball.reset(WIDTH / 2 - BALL_SIZE / 2, HEIGHT / 2 - BALL_SIZE / 2);
        }

        player1.move();
        player2.move();

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player1.draw(g);
        player2.draw(g);
        ball.draw(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        player1.keyPressed(e);
        player2.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player1.keyReleased(e);
        player2.keyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong Game");
        PongGame pongGame = new PongGame();
        frame.add(pongGame);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Accessor methods for the constants
    public static int getPaddleWidth() {
        return PADDLE_WIDTH;
    }

    public static int getPaddleHeight() {
        return PADDLE_HEIGHT;
    }

    public static int getBallSize() {
        return BALL_SIZE;
    }

    public static int getPaddleSpeed() {
        return PADDLE_SPEED;
    }

    public static int getBallSpeedX() {
        return BALL_SPEED_X;
    }

    public static int getBallSpeedY() {
        return BALL_SPEED_Y;
    }
}
