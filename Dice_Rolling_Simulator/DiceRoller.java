public class DiceRoller {
    private Dice[] dice;

    // Constructor
    public DiceRoller(int numDice, int sides) {
        dice = new Dice[numDice];
        for (int i = 0; i < numDice; i++) {
            dice[i] = new Dice(sides);
        }
    }

    // Method to roll all dice
    public void rollAllDice() {
        for (Dice die : dice) {
            die.roll();
        }
    }

    // Method to get the result of all dice rolls
    public int[] getResults() {
        int[] results = new int[dice.length];
        for (int i = 0; i < dice.length; i++) {
            results[i] = dice[i].getValue();
        }
        return results;
    }

    // Method to display the results of all dice rolls
    public void displayResults() {
        System.out.print("Dice rolls: ");
        for (int result : getResults()) {
            System.out.print(result + " ");
        }
        System.out.println();
    }
}
