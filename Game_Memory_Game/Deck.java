import java.util.Random;

public class Deck {
    private Card[] cards;
    private Random random;

    public Deck(int numPairs) {
        cards = new Card[numPairs * 2];
        random = new Random();
        String[] values = new String[numPairs];
        for (int i = 0; i < numPairs; i++) {
            values[i] = String.valueOf(i + 1);
        }

        int index = 0;
        for (String value : values) {
            cards[index++] = new Card(value);
            cards[index++] = new Card(value);
        }
        shuffle();
    }

    public Card getCard(int index) {
        return cards[index];
    }

    public int size() {
        return cards.length;
    }

    private void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int randomIndex = random.nextInt(cards.length);
            Card temp = cards[i];
            cards[i] = cards[randomIndex];
            cards[randomIndex] = temp;
        }
    }
}
