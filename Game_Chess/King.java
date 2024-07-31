public class King extends Piece {
    public King(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    @Override
    public boolean isValidMove(int newX, int newY, Board board) {
        // King moves one square in any direction
        int dx = Math.abs(newX - x);
        int dy = Math.abs(newY - y);
        return (dx <= 1 && dy <= 1);
    }
}
