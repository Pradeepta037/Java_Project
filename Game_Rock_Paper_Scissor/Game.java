import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        System.out.println("Player 1's move:");
        player1.makeMove();
        System.out.println("Player 2's move:");
        player2.makeMove();

        System.out.println("Result: " + determineWinner());
    }

    private String determineWinner() {
        String move1 = player1.getMove();
        String move2 = player2.getMove();

        if (move1.equals(move2)) {
            return "It's a tie!";
        } else if ((move1.equals("Rock") && move2.equals("Scissors")) ||
                   (move1.equals("Scissors") && move2.equals("Paper")) ||
                   (move1.equals("Paper") && move2.equals("Rock"))) {
            return "Player 1 wins!";
        } else {
            return "Player 2 wins!";
        }
    }
}
