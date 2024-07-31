import java.util.Scanner;

public class Game {
    private Board board;
    private boolean whiteTurn;

    public Game() {
        board = new Board();
        whiteTurn = true;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            board.printBoard();
            System.out.println((whiteTurn ? "White" : "Black") + "'s turn");

            System.out.print("Enter move (e.g., 0 1 0 2): ");
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();

            board.movePiece(x1, y1, x2, y2);
            whiteTurn = !whiteTurn; // Switch turn
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
