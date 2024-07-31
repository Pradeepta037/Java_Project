// Main class to start the game

import java.util.Scanner;

public class MiniMathGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        Player player = new Player(playerName);
        Game game = new Game(player);
        game.start();
    }
}
