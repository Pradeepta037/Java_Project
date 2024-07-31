import java.util.Random;

public class TextProvider {
    private static final String[] EASY_TEXTS = {
        "The quick brown fox",
        "Java is fun",
        "Easy typing test",
        "Practice typing daily",
        "Improve your speed"
    };

    private static final String[] MEDIUM_TEXTS = {
        "The quick brown fox jumps over the lazy dog",
        "Java programming is both fun and educational",
        "Object-oriented programming helps in building scalable software",
        "Typing speed tests can help improve your typing skills",
        "Practice makes perfect in any skill development"
    };

    private static final String[] HARD_TEXTS = {
        "A quick brown fox jumps over a lazy dog, but what if the fox had a special mission to accomplish and the dog was not just any dog?",
        "Advanced Java programming involves understanding complex concepts such as multithreading, concurrency, and design patterns to build robust applications.",
        "Typing speed tests with complex sentences can significantly improve cognitive skills and typing accuracy over time, challenging your mental agility.",
        "Mastering the art of typing quickly and accurately requires persistent practice and adapting to increasingly challenging texts.",
        "In-depth knowledge of Java's memory management and garbage collection processes is crucial for optimizing application performance and resource utilization."
    };

    public String getTextByDifficulty(String difficulty) {
        Random random = new Random();
        switch (difficulty.toLowerCase()) {
            case "easy":
                return EASY_TEXTS[random.nextInt(EASY_TEXTS.length)];
            case "medium":
                return MEDIUM_TEXTS[random.nextInt(MEDIUM_TEXTS.length)];
            case "hard":
                return HARD_TEXTS[random.nextInt(HARD_TEXTS.length)];
            default:
                throw new IllegalArgumentException("Invalid difficulty level");
        }
    }
}
