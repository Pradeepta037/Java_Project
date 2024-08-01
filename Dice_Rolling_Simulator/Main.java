import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Dice Rolling Simulator!");

        System.out.print("Enter the number of dice: ");
        int numDice = scanner.nextInt();

        System.out.print("Enter the number of sides on each die: ");
        int sides = scanner.nextInt();

        DiceRoller diceRoller = new DiceRoller(numDice, sides);

        boolean keepRolling = true;
        while (keepRolling) {
            diceRoller.rollAllDice();
            diceRoller.displayResults();

            System.out.print("Do you want to roll again? (yes/no): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("no")) {
                keepRolling = false;
            }
        }

        System.out.println("Thank you for using the Dice Rolling Simulator!");
        scanner.close();
    }
}
