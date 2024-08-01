import java.util.Scanner;

public class Game {
    private Deck deck;
    private int numPairs;
    private int matchesFound;
    private Scanner scanner;

    public Game(int numPairs) {
        this.numPairs = numPairs;
        this.deck = new Deck(numPairs);
        this.matchesFound = 0;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (matchesFound < numPairs) {
            printBoard();
            System.out.println("Select two cards to flip (0-" + (deck.size() - 1) + "):");
            int firstIndex = scanner.nextInt();
            int secondIndex = scanner.nextInt();

            if (firstIndex == secondIndex || firstIndex < 0 || firstIndex >= deck.size() || secondIndex < 0 || secondIndex >= deck.size()) {
                System.out.println("Invalid indices. Try again.");
                continue;
            }

            Card firstCard = deck.getCard(firstIndex);
            Card secondCard = deck.getCard(secondIndex);

            firstCard.flip();
            secondCard.flip();
            printBoard();

            if (firstCard.getValue().equals(secondCard.getValue())) {
                System.out.println("It's a match!");
                matchesFound++;
            } else {
                System.out.println("Not a match. Try again.");
                firstCard.flip();
                secondCard.flip();
            }
        }
        System.out.println("Congratulations! You've matched all pairs.");
    }

    private void printBoard() {
        for (int i = 0; i < deck.size(); i++) {
            System.out.print(deck.getCard(i) + " ");
            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
