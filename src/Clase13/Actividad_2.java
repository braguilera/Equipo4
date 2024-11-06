package Clase13;

public class Actividad_2 {
    private final int SIZE = 6;
    private final int SUBGRID_ROWS = 2;
    private final int SUBGRID_COLS = 3;
    private int[][] board = new int[SIZE][SIZE];

    private boolean isSafe(int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        int startRow = row - row % SUBGRID_ROWS;
        int startCol = col - col % SUBGRID_COLS;
        for (int i = 0; i < SUBGRID_ROWS; i++) {
            for (int j = 0; j < SUBGRID_COLS; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (isSafe(row, col, num)) {
                            board[row][col] = num;
                            if (solve()) {
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for (int r = 0; r < SIZE; r++) {
            for (int d = 0; d < SIZE; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Actividad_2 sudoku = new Actividad_2();

        int[][] board = {
                {0, 3, 0, 4, 0, 0},
                {0, 0, 5, 6, 0, 3},
                {0, 0, 0, 1, 0, 0},
                {0, 1, 0, 3, 0, 5},
                {0, 6, 4, 0, 3, 1},
                {0, 0, 1, 0, 4, 6}
        };
        sudoku.board = board;

        if (sudoku.solve()) {
            System.out.println("Sudoku resuelto:");
            sudoku.printBoard();
        } else {
            System.out.println("No se puede resolver este Sudoku.");
        }
    }
}

