import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private WaterGun waterGun;

    public Game(Player p1, Player p2, WaterGun gun) {
        this.player1 = p1;
        this.player2 = p2;
        this.waterGun = gun;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {
            takeTurn(player1, player2, scanner);
            if (isGameOver()) {
                gameOver = true;
                System.out.println(player2.getName() + " wins!");
                break;
            }

            takeTurn(player2, player1, scanner);
            if (isGameOver()) {
                gameOver = true;
                System.out.println(player1.getName() + " wins!");
            }
        }
        scanner.close();
    }

    private void takeTurn(Player currentPlayer, Player opponent, Scanner scanner) {
        System.out.println(currentPlayer.getName() + "'s turn.");
        System.out.println("1. Shoot Water");
        System.out.println("2. Refill Water");
        System.out.print("Choose an action: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                currentPlayer.shoot(waterGun, opponent);
                break;
            case 2:
                currentPlayer.refill(10); // Refill amount can be adjusted
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    private boolean isGameOver() {
        return player1.getWaterLevel() <= 0 || player2.getWaterLevel() <= 0;
    }

    public static void main(String[] args) {
        Player p1 = new Player("Alice", 50);
        Player p2 = new Player("Bob", 50);
        WaterGun gun = new WaterGun(100, 10);
        Game game = new Game(p1, p2, gun);
        game.start();
    }
}
