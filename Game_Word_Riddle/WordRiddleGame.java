public class WordRiddleGame {
    private Riddle[] riddles;
    private Player player;
    private int score;

    public WordRiddleGame() {
        riddles = new Riddle[] {
            new Riddle("What has keys but can't open locks?", "piano"),
            new Riddle("What has hands but can't clap?", "clock"),
            new Riddle("What can travel around the world while staying in a corner?", "stamp"),
            new Riddle("What has a neck but no head?", "bottle"),
            new Riddle("What has an eye but cannot see?", "needle"),
            new Riddle("What has to be broken before you can use it?", "egg"),
            new Riddle("What begins with T, ends with T, and has T in it?", "teapot"),
            new Riddle("What is full of holes but still holds water?", "sponge"),
            new Riddle("What gets wetter as it dries?", "towel"),
            new Riddle("What comes once in a minute, twice in a moment, but never in a thousand years?", "M")
        };
        player = new Player("Player1");
        score = 0;
    }

    public void startGame() {
        System.out.println("Welcome to the Word Riddle Game, " + player.getName() + "!");
        for (Riddle riddle : riddles) {
            System.out.println(riddle.getQuestion());
            String answer = player.getAnswer();
            if (riddle.checkAnswer(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + riddle.getAnswer());
            }
        }
        displayScore();
    }

    private void displayScore() {
        System.out.println("Game Over! Your score is: " + score + "/" + riddles.length);
    }
}
