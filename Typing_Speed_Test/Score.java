public class Score {
    private String text;
    private long timeInSeconds;

    public Score(String text, long timeInSeconds) {
        this.text = text;
        this.timeInSeconds = timeInSeconds;
    }

    public int calculateWordsPerMinute() {
        int wordCount = text.split("\\s+").length;
        return (int) ((wordCount / (double) timeInSeconds) * 60);
    }

    public void displayScore() {
        System.out.println("Your typing speed: " + calculateWordsPerMinute() + " WPM");
    }
}
