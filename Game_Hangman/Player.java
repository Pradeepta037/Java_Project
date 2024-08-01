class Player {
    private String name;
    private int attempts;

    public Player(String name, int attempts) {
        this.name = name;
        this.attempts = attempts;
    }

    public String getName() {
        return name;
    }

    public int getAttempts() {
        return attempts;
    }

    public void decrementAttempts() {
        attempts--;
    }
}
