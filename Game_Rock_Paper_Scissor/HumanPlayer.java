import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void makeMove() {
        System.out.println("Enter your move (Rock, Paper, Scissors):");
        move = scanner.nextLine();
    }
}
