import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Game extends JPanel implements ActionListener {
    private Bird bird;
    private List<Pipe> pipes;
    private Timer timer;

    public Game() {
        this.bird = new Bird(100, 100);
        this.pipes = new ArrayList<>();
        this.pipes.add(new Pipe(400, 100));

        this.timer = new Timer(20, this);
        this.timer.start();

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    bird.flap();
                }
            }
        });
        this.setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(bird.getX(), bird.getY(), 20, 20);

        g.setColor(Color.GREEN);
        for (Pipe pipe : pipes) {
            g.fillRect(pipe.getX(), pipe.getY(), pipe.getWidth(), 300);
            g.fillRect(pipe.getX(), pipe.getY() + pipe.getGap() + 100, pipe.getWidth(), getHeight() - pipe.getY() - pipe.getGap() - 100);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bird.update();
        for (Pipe pipe : pipes) {
            pipe.move();
            if (pipe.getX() + pipe.getWidth() < 0) {
                pipes.remove(pipe);
                pipes.add(new Pipe(400, (int) (Math.random() * 200)));
            }
        }

        if (pipes.stream().anyMatch(pipe -> pipe.collidesWith(bird))) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Game Over");
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flappy Bird");
        Game game = new Game();
        frame.add(game);
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
