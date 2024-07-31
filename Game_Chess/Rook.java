public class Rook extends Piece {
    public Rook(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    @Override
    public boolean isValidMove(int newX, int newY, Board board) {
        // Rook moves in straight lines (horizontally or vertically)
        return (x == newX || y == newY);
    }
}
