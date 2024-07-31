import java.util.Scanner;

public class TypingSpeedTest {
    public static void main(String[] args) {
        TextProvider textProvider = new TextProvider();
        Timer timer = new Timer();
        Scanner scanner = new Scanner(System.in);

        // Choose difficulty level
        System.out.println("Choose difficulty level (easy, medium, hard):");
        String difficulty = scanner.nextLine().trim().toLowerCase();

        // Validate difficulty level
        if (!difficulty.equals("easy") && !difficulty.equals("medium") && !difficulty.equals("hard")) {
            System.out.println("Invalid difficulty level.");
            scanner.close();
            return;
        }

        // Provide the text to be typed
        String text = textProvider.getTextByDifficulty(difficulty);
        System.out.println("\nYour text to type is:");
        System.out.println(text);
        System.out.println();

        // Start the timer
        timer.start();

        // Get user input
        System.out.println("Start typing:");
        String userInput = scanner.nextLine();

        // Stop the timer
        timer.stop();

        // Calculate and display the score
        if (userInput.equals(text)) {
            Score score = new Score(text, timer.getDurationInSeconds());
            score.displayScore();
        } else {
            System.out.println("The text you typed did not match the given text.");
        }

        scanner.close();
    }
}