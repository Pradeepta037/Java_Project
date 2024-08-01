import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JFrame implements ActionListener {

    private final Timer timer;
    private final Paddle paddle;
    private final Ball ball;
    private final Brick[][] bricks;

    public Game() {
        setTitle("Brick Breaker");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        paddle = new Paddle();
        ball = new Ball();
        bricks = new Brick[5][10];

        // Initialize bricks
        for (int row = 0; row < bricks.length; row++) {
            for (int col = 0; col < bricks[row].length; col++) {
                bricks[row][col] = new Brick(80 * col, 30 * row);
            }
        }

        timer = new Timer(10, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                paddle.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                paddle.keyReleased(e);
            }
        });

        setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ball.move();
        ball.checkCollision(paddle);
        ball.checkCollision(bricks);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        paddle.draw(g);
        ball.draw(g);
        for (Brick[] row : bricks) {
            for (Brick brick : row) {
                brick.draw(g);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Game game = new Game();
            game.setVisible(true);
        });
    }
}
