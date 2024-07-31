import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Point;

public class Game extends JFrame {
    private Board board;
    private Timer timer;
    private final int DELAY = 100; // milliseconds

    public Game() {
        board = new Board();
        add(board);
        pack();
        setTitle("Snake Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateGame();
            }
        });
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP: 
                        if (board.getSnake().getDirection() != Direction.DOWN) 
                            board.getSnake().setDirection(Direction.UP);
                        break;
                    case KeyEvent.VK_DOWN: 
                        if (board.getSnake().getDirection() != Direction.UP) 
                            board.getSnake().setDirection(Direction.DOWN);
                        break;
                    case KeyEvent.VK_LEFT: 
                        if (board.getSnake().getDirection() != Direction.RIGHT) 
                            board.getSnake().setDirection(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT: 
                        if (board.getSnake().getDirection() != Direction.LEFT) 
                            board.getSnake().setDirection(Direction.RIGHT);
                        break;
                }
            }
        });
    }

    private void updateGame() {
        Snake snake = board.getSnake();
        snake.move();
        if (snake.getBody().getFirst().equals(board.getFood().getLocation())) {
            snake.grow();
            board.getFood().setLocation(generateRandomPoint());
        }
        repaint();
    }

    private Point generateRandomPoint() {
        int x = (int) (Math.random() * (board.getWidth() / 10)) * 10;
        int y = (int) (Math.random() * (board.getHeight() / 10)) * 10;
        return new Point(x, y);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Game());
    }
}
