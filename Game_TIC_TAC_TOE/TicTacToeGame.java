import java.util.Scanner;

public class TicTacToeGame {
    private GameBoard board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public TicTacToeGame(Player player1, Player player2) {
        this.board = new GameBoard();
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    public void play() {
        while (true) {
            board.printBoard();
            int move = currentPlayer.getMove(board);
            board.makeMove(move, currentPlayer.getSymbol());

            if (board.checkWin(currentPlayer.getSymbol())) {
                board.printBoard();
                System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                break;
            } else if (board.isBoardFull()) {
                board.printBoard();
                System.out.println("The game is a draw.");
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose player 1 type (human/ai): ");
        String player1Type = scanner.nextLine().trim().toLowerCase();
        Player player1 = player1Type.equals("human") ? new HumanPlayer('X') : new AIPlayer('X');

        System.out.print("Choose player 2 type (human/ai): ");
        String player2Type = scanner.nextLine().trim().toLowerCase();
        Player player2 = player2Type.equals("human") ? new HumanPlayer('O') : new AIPlayer('O');

        TicTacToeGame game = new TicTacToeGame(player1, player2);
        game.play();
        // scanner.close();
    }
}
