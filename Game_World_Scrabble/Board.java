public class Board {
    private Tile[][] board;

    public Board(int size) {
        board = new Tile[size][size];
        // Initialize board with empty tiles or predefined tiles if needed
    }

    public void placeTile(int row, int col, Tile tile) {
        board[row][col] = tile;
    }

    public Tile getTile(int row, int col) {
        return board[row][col];
    }

    public void printBoard() {
        for (Tile[] row : board) {
            for (Tile tile : row) {
                if (tile == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(tile.getLetter() + " ");
                }
            }
            System.out.println();
        }
    }
}
