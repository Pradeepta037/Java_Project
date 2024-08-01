public class Card {
    private String value;
    private boolean faceUp;

    public Card(String value) {
        this.value = value;
        this.faceUp = false;
    }

    public String getValue() {
        return value;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void flip() {
        faceUp = !faceUp;
    }

    @Override
    public String toString() {
        return faceUp ? value : "*";
    }
}
