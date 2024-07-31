public class Queen extends Piece {
    public Queen(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    @Override
    public boolean isValidMove(int newX, int newY, Board board) {
        int dx = Math.abs(newX - x);
        int dy = Math.abs(newY - y);
        return (dx == dy || x == newX || y == newY);
    }
}
