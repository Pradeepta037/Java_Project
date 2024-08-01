public class Dice {
    private int sides;
    private int value;

    // Constructor
    public Dice(int sides) {
        this.sides = sides;
        roll();  // Roll the die initially
    }

    // Method to roll the dice
    public void roll() {
        value = (int) (Math.random() * sides) + 1;
    }

    // Method to get the value of the dice
    public int getValue() {
        return value;
    }

    // Method to set the number of sides
    public void setSides(int sides) {
        this.sides = sides;
    }

    // Method to get the number of sides
    public int getSides() {
        return sides;
    }
}
