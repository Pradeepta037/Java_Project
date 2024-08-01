import java.util.Random;

public class Grid {
    private int width;
    private int height;
    private Mole[][] grid;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Mole[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = new Mole();
            }
        }
    }

    public void placeRandomMole() {
        Random rand = new Random();
        int x = rand.nextInt(width);
        int y = rand.nextInt(height);
        grid[x][y].appear(x, y);
    }

    public void removeMole(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            grid[x][y].disappear();
        }
    }

    public Mole getMole(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return grid[x][y];
        }
        return null;
    }

    public void printGrid() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (grid[i][j].isActive()) {
                    System.out.print("M ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
