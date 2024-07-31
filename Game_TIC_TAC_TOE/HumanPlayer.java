import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(char symbol) {
        super(symbol);
    }

    @Override
    public int getMove(GameBoard board) {
        Scanner scanner = new Scanner(System.in);
        int move;
        do {
            System.out.print("Enter your move (1-9): ");
            move = scanner.nextInt() - 1;
        } while (move < 0 || move >= 9 || board.isCellOccupied(move));
        // scanner.close();
        return move;
        
    }
}
