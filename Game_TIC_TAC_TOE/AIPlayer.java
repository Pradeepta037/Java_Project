import java.util.Random;

public class AIPlayer extends Player {

    public AIPlayer(char symbol) {
        super(symbol);
    }

    @Override
    public int getMove(GameBoard board) {
        Random rand = new Random();
        int move;
        do {
            move = rand.nextInt(9);
        } while (board.isCellOccupied(move));
        return move;
    }
}
