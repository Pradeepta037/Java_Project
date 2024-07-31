public class Board {
    private Piece[][] board;

    public Board() {
        board = new Piece[8][8];
        setupBoard();
    }

    private void setupBoard() {
        // Setup initial positions for pieces
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(1, i, true);  // White pawns
            board[6][i] = new Pawn(6, i, false); // Black pawns
        }
        board[0][0] = new Rook(0, 0, true);
        board[0][1] = new Knight(0, 1, true);
        board[0][2] = new Bishop(0, 2, true);
        board[0][3] = new Queen(0, 3, true);
        board[0][4] = new King(0, 4, true);
        board[0][5] = new Bishop(0, 5, true);
        board[0][6] = new Knight(0, 6, true);
        board[0][7] = new Rook(0, 7, true);

        board[7][0] = new Rook(7, 0, false);
        board[7][1] = new Knight(7, 1, false);
        board[7][2] = new Bishop(7, 2, false);
        board[7][3] = new Queen(7, 3, false);
        board[7][4] = new King(7, 4, false);
        board[7][5] = new Bishop(7, 5, false);
        board[7][6] = new Knight(7, 6, false);
        board[7][7] = new Rook(7, 7, false);
    }

    public Piece getPiece(int x, int y) {
        return board[x][y];
    }

    public void movePiece(int x1, int y1, int x2, int y2) {
        Piece piece = getPiece(x1, y1);
        if (piece != null && piece.isValidMove(x2, y2, this)) {
            board[x2][y2] = piece;
            board[x1][y1] = null;
            piece.move(x2, y2);
        }
    }

    public void printBoard() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board[i][j];
                if (piece == null) {
                    System.out.print("[ ] ");
                } else {
                    System.out.print("[" + piece + "] ");
                }
            }
            System.out.println();
        }
    }
}
