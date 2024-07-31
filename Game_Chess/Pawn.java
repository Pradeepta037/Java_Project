public class Pawn extends Piece {
    public Pawn(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    @Override
    public boolean isValidMove(int newX, int newY, Board board) {
        int dx = newX - x;
        int dy = newY - y;

        if (isWhite) {
            if (x == 1 && dy == 0 && dx == 2 && board.getPiece(newX, newY) == null) {
                return true; // White pawn's initial two-square move
            }
            if (dy == 0 && dx == 1 && board.getPiece(newX, newY) == null) {
                return true; // White pawn moves one square forward
            }
            if (dy == 1 && dx == 1 && board.getPiece(newX, newY) != null && !board.getPiece(newX, newY).isWhite()) {
                return true; // White pawn captures diagonally
            }
        } else {
            if (x == 6 && dy == 0 && dx == -2 && board.getPiece(newX, newY) == null) {
                return true; // Black pawn's initial two-square move
            }
            if (dy == 0 && dx == -1 && board.getPiece(newX, newY) == null) {
                return true; // Black pawn moves one square forward
            }
            if (dy == 1 && dx == -1 && board.getPiece(newX, newY) != null && board.getPiece(newX, newY).isWhite()) {
                return true; // Black pawn captures diagonally
            }
        }

        return false;
    }
}
