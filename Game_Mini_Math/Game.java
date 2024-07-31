import java.util.Scanner;

// Class to manage the game
class Game {
    private Player player;
    private Scanner scanner;

    public Game(Player player) {
        this.player = player;
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Mini Math Game, " + player.getName() + "!");
        int totalQuestions = 10;
        int correctAnswers = 0;

        for (int i = 1; i <= totalQuestions; i++) {
            System.out.println("Question " + i + ":");
            Question question = new Question();
            question.displayQuestion();

            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (question.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("Wrong answer. The correct answer was " + question.getAnswer() + ".");
            }

            System.out.println("Current score: " + correctAnswers + "/" + i);
        }

        System.out.println("Game over! Final score: " + correctAnswers + "/" + totalQuestions);
    }
}


// import java.util.Scanner;
// import java.util.Timer;
// import java.util.TimerTask;

// // Class to manage the game
// class Game {
//     private Player player;
//     private Scanner scanner;
//     private static final int TIME_LIMIT = 15; // Time limit in seconds

//     public Game(Player player) {
//         this.player = player;
//         scanner = new Scanner(System.in);
//     }

//     public void start() {
//         System.out.println("Welcome to the Mini Math Game, " + player.getName() + "!");
//         int totalQuestions = 10;
//         int correctAnswers = 0;

//         for (int i = 1; i <= totalQuestions; i++) {
//             System.out.println("Question " + i + ":");
//             Question question = new Question();
//             question.displayQuestion();

//             // Start a timer task for the time limit
//             Timer timer = new Timer();
//             TimerTask task = new TimerTask() {
//                 @Override
//                 public void run() {
//                     System.out.println("\nTime's up! Moving to the next question.");
//                     scanner.close(); // Close the scanner if time runs out
//                 }
//             };
//             timer.schedule(task, TIME_LIMIT * 1000); // Schedule task for 15 seconds

//             long startTime = System.currentTimeMillis();
//             boolean answered = false;
//             int userAnswer = 0;

//             while (System.currentTimeMillis() - startTime < TIME_LIMIT * 1000) {
//                 if (scanner.hasNextInt()) {
//                     userAnswer = scanner.nextInt();
//                     answered = true;
//                     break;
//                 }
//             }

//             if (!answered) {
//                 System.out.println("Time's up! The correct answer was " + question.getAnswer() + ".");
//             } else {
//                 if (question.checkAnswer(userAnswer)) {
//                     System.out.println("Correct!");
//                     correctAnswers++;
//                 } else {
//                     System.out.println("Wrong answer. The correct answer was " + question.getAnswer() + ".");
//                 }
//             }

//             System.out.println("Current score: " + correctAnswers + "/" + i);
//         }

//         System.out.println("Game over! Final score: " + correctAnswers + "/" + totalQuestions);
//     }
// }

