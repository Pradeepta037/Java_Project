import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PacmanGame extends JFrame implements ActionListener {

    private Timer timer;
    private Pacman pacman;
    private List<Ghost> ghosts;
    private List<Point> pellets;
    private int score;

    public PacmanGame() {
        setTitle("Pac-Man Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        pacman = new Pacman(400, 300);
        ghosts = new ArrayList<>();
        pellets = new ArrayList<>();
        score = 0;

        ghosts.add(new Ghost(100, 100));
        ghosts.add(new Ghost(700, 500));

        // Initialize pellets
        for (int i = 0; i < 50; i++) {
            pellets.add(new Point((int) (Math.random() * 780), (int) (Math.random() * 580)));
        }

        timer = new Timer(16, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                pacman.handleKeyPress(e.getKeyCode());
            }
        });

        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pacman.move();
        for (Ghost ghost : ghosts) {
            ghost.move();
        }

        checkCollisions();
        repaint();
    }

    private void checkCollisions() {
        // Check for collision with ghosts
        for (Ghost ghost : ghosts) {
            if (pacman.getBounds().intersects(ghost.getBounds())) {
                // Handle collision with ghost (game over, etc.)
                System.out.println("Game Over!");
                System.exit(0);
            }
        }

        // Check for collision with pellets
        for (Point pellet : pellets) {
            if (pacman.getBounds().contains(pellet)) {
                pellets.remove(pellet);
                score += 10;
                break;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Draw Pac-Man
        pacman.draw(g);

        // Draw ghosts
        for (Ghost ghost : ghosts) {
            ghost.draw(g);
        }

        // Draw pellets
        g.setColor(Color.YELLOW);
        for (Point pellet : pellets) {
            g.fillOval(pellet.x, pellet.y, 10, 10);
        }

        // Draw score
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 10, 10);
    }

    public static void main(String[] args) {
        new PacmanGame();
    }
}

class Pacman {
    private int x, y, dx, dy;
    private final int size = 20;

    public Pacman(int x, int y) {
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
    }

    public void handleKeyPress(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                dx = 0;
                dy = -5;
                break;
            case KeyEvent.VK_DOWN:
                dx = 0;
                dy = 5;
                break;
            case KeyEvent.VK_LEFT:
                dx = -5;
                dy = 0;
                break;
            case KeyEvent.VK_RIGHT:
                dx = 5;
                dy = 0;
                break;
        }
    }

    public void move() {
        x += dx;
        y += dy;
        x = Math.max(0, Math.min(x, 780)); // Ensure Pac-Man stays within bounds
        y = Math.max(0, Math.min(y, 580));
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillArc(x, y, size, size, 45, 270);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }
}

class Ghost {
    private int x, y;
    private final int size = 20;

    public Ghost(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        // Simple random movement for the ghost
        x += (Math.random() * 6 - 3);
        y += (Math.random() * 6 - 3);
        x = Math.max(0, Math.min(x, 780));
        y = Math.max(0, Math.min(y, 580));
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, size, size);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }
}
