public class Bishop extends Piece {
    public Bishop(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    @Override
    public boolean isValidMove(int newX, int newY, Board board) {
        // Bishop moves diagonally
        return Math.abs(newX - x) == Math.abs(newY - y);
    }
}
