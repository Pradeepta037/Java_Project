class Word {
    private String word;
    private StringBuilder displayWord;

    public Word(String word) {
        this.word = word;
        this.displayWord = new StringBuilder("_".repeat(word.length()));
    }

    public boolean guessLetter(char letter) {
        boolean found = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                displayWord.setCharAt(i, letter);
                found = true;
            }
        }
        return found;
    }

    public boolean isWordGuessed() {
        return displayWord.indexOf("_") == -1;
    }

    public String getDisplayWord() {
        return displayWord.toString();
    }
}
