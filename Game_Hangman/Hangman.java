public class Hangman {
    public static void main(String[] args) {
        Word word = new Word("java");
        Player player = new Player("John Doe", 7);
        HangmanGame game = new HangmanGame(word, player);
        game.play();
    }
}
