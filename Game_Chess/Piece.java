abstract class Piece {
    protected int x, y; // Position on the board
    protected boolean isWhite; // Color of the piece

    public Piece(int x, int y, boolean isWhite) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
    }

    public abstract boolean isValidMove(int newX, int newY, Board board);

    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isWhite() {
        return isWhite;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + (isWhite ? "W" : "B");
    }
}
