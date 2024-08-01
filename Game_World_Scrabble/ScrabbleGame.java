import java.util.Scanner;

public class ScrabbleGame {
    private Board board;
    private Player player;
    private Dictionary dictionary;

    public ScrabbleGame(int boardSize, String playerName) {
        board = new Board(boardSize);
        player = new Player(playerName);
        dictionary = new Dictionary();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Current Board:");
            board.printBoard();
            System.out.println("Player: " + player.getName() + " | Score: " + player.getScore());

            System.out.println("Enter a command (place/exit): ");
            String command = scanner.nextLine();
            
            if (command.equals("exit")) {
                break;
            }

            if (command.equals("place")) {
                System.out.println("Enter row, column, letter, and points (e.g., 0 0 A 1): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                char letter = scanner.next().charAt(0);
                int points = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                Tile tile = new Tile(letter, points);
                board.placeTile(row, col, tile);
                
                System.out.println("Enter word formed (or type 'skip'): ");
                String word = scanner.nextLine();

                if (!word.equals("skip") && dictionary.isValidWord(word)) {
                    player.addScore(calculateScore(word));
                } else {
                    System.out.println("Invalid word or skipped.");
                }
            }
        }
        scanner.close();
        System.out.println("Game Over. Final Score: " + player.getScore());
    }

    private int calculateScore(String word) {
        int score = 0;
        for (char c : word.toCharArray()) {
            // Assume points for each letter is 1 (can be customized)
            score += 1; 
        }
        return score;
    }

    public static void main(String[] args) {
        ScrabbleGame game = new ScrabbleGame(15, "Player1");
        game.startGame();
    }
}
