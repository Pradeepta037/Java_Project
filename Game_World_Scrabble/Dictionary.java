import java.util.Arrays;

public class Dictionary {
    private String[] words;

    public Dictionary() {
        words = new String[] {
            "example", "java", "world", "scrabble", "game"
            // Add more words as needed
        };
    }

    public boolean isValidWord(String word) {
        // Convert the word to lower case to handle case insensitivity
        word = word.toLowerCase();
        for (String validWord : words) {
            if (validWord.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
