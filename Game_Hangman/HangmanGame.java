class HangmanGame {
    private Word word;
    private Player player;

    public HangmanGame(Word word, Player player) {
        this.word = word;
        this.player = player;
    }

    public void play() {
        System.out.println("Welcome " + player.getName() + "! Let's start the Hangman game.");
        while (player.getAttempts() > 0 && !word.isWordGuessed()) {
            System.out.println("Word: " + word.getDisplayWord());
            System.out.println("Attempts left: " + player.getAttempts());
            System.out.print("Guess a letter: ");
            char guess = new java.util.Scanner(System.in).nextLine().charAt(0);

            if (word.guessLetter(guess)) {
                System.out.println("Good guess!");
            } else {
                System.out.println("Wrong guess.");
                player.decrementAttempts();
            }
            
        }

        if (word.isWordGuessed()) {
            System.out.println("Congratulations! You've guessed the word: " + word.getDisplayWord());
        } else {
            System.out.println("Game over! The word was: " + word.getDisplayWord());
        }
    }
}
