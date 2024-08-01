import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PingPongGame extends JPanel implements ActionListener {
    private Ball ball;
    private Paddle paddle1, paddle2;
    private Timer timer;
    private final int PADDLE_WIDTH = 10;
    private final int PADDLE_HEIGHT = 60;
    private final int BALL_DIAMETER = 20;

    public PingPongGame() {
        ball = new Ball(100, 100, BALL_DIAMETER, 2, 2, Color.RED);
        paddle1 = new Paddle(30, 100, PADDLE_WIDTH, PADDLE_HEIGHT, Color.BLUE);
        paddle2 = new Paddle(460, 100, PADDLE_WIDTH, PADDLE_HEIGHT, Color.GREEN);

        timer = new Timer(10, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    paddle2.move(-10);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    paddle2.move(10);
                } else if (e.getKeyCode() == KeyEvent.VK_W) {
                    paddle1.move(-10);
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    paddle1.move(10);
                }
            }
        });
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.paint(g);
        paddle1.paint(g);
        paddle2.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ball.move();
        ball.checkCollision(getBounds());
        checkPaddleCollision(paddle1);
        checkPaddleCollision(paddle2);
        repaint();
    }

    private void checkPaddleCollision(Paddle paddle) {
        if (ball.getBounds().intersects(paddle.getBounds())) {
            // Reverse the ball's X velocity when it hits a paddle
            // ball.setXVelocity(-ball.getBounds().xVelocity);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ping Pong Game");
        PingPongGame game = new PingPongGame();
        frame.add(game);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
