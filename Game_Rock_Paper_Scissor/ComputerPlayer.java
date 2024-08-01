import java.util.Random;

public class ComputerPlayer extends Player {
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};
    private Random random;

    public ComputerPlayer() {
        this.random = new Random();
    }

    @Override
    public void makeMove() {
        move = MOVES[random.nextInt(MOVES.length)];
        System.out.println("Computer chooses: " + move);
    }
}
