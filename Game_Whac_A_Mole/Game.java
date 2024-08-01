import java.util.Scanner;

public class Game {
    private Grid grid;
    private int score;
    private Scanner scanner;

    public Game(int width, int height) {
        grid = new Grid(width, height);
        score = 0;
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to Whac-A-Mole!");
        while (true) {
            grid.placeRandomMole();
            grid.printGrid();
            System.out.println("Enter the coordinates to whack a mole (x y) or 'q' to quit:");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println("Invalid input. Please enter two numbers.");
                continue;
            }

            try {
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                Mole mole = grid.getMole(x, y);

                if (mole != null && mole.isActive()) {
                    score++;
                    grid.removeMole(x, y);
                    System.out.println("Good hit! Your score is " + score);
                } else {
                    System.out.println("Missed! Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numbers.");
            }
        }

        System.out.println("Game Over! Your final score is " + score);
        scanner.close();
    }

    public static void main(String[] args) {
        Game game = new Game(5, 5);
        game.start();
    }
}
