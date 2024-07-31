public class GameBoard {
    private char[] cells = new char[9];

    public GameBoard() {
        for (int i = 0; i < 9; i++) {
            cells[i] = ' ';
        }
    }

    public void printBoard() {
        System.out.println(" " + cells[0] + " | " + cells[1] + " | " + cells[2]);
        System.out.println("---|---|---");
        System.out.println(" " + cells[3] + " | " + cells[4] + " | " + cells[5]);
        System.out.println("---|---|---");
        System.out.println(" " + cells[6] + " | " + cells[7] + " | " + cells[8]);
    }

    public boolean isCellOccupied(int index) {
        return cells[index] != ' ';
    }

    public void makeMove(int index, char symbol) {
        if (index >= 0 && index < 9 && cells[index] == ' ') {
            cells[index] = symbol;
        }
    }

    public boolean checkWin(char symbol) {
        // Check rows, columns, and diagonals
        return (cells[0] == symbol && cells[1] == symbol && cells[2] == symbol) ||
               (cells[3] == symbol && cells[4] == symbol && cells[5] == symbol) ||
               (cells[6] == symbol && cells[7] == symbol && cells[8] == symbol) ||
               (cells[0] == symbol && cells[3] == symbol && cells[6] == symbol) ||
               (cells[1] == symbol && cells[4] == symbol && cells[7] == symbol) ||
               (cells[2] == symbol && cells[5] == symbol && cells[8] == symbol) ||
               (cells[0] == symbol && cells[4] == symbol && cells[8] == symbol) ||
               (cells[2] == symbol && cells[4] == symbol && cells[6] == symbol);
    }

    public boolean isBoardFull() {
        for (char cell : cells) {
            if (cell == ' ') {
                return false;
            }
        }
        return true;
    }
}
