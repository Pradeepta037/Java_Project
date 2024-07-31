import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

public class Board extends JPanel {
    private Snake snake;
    private Food food;
    private final int WIDTH = 400;
    private final int HEIGHT = 400;

    public Board() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        food = new Food(WIDTH, HEIGHT);
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake.draw(g);
        food.draw(g);
    }
}
