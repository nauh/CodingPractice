import java.util.HashSet;
import java.util.Set;

public class SudokuSolver implements Runnable {

    @Override
    public void run() {
    }

    public void solveSudoku(char[][] board) {
        if (!isValidSudoku(board)) {
            return;
        }
        solveSudoku(board, 0);
    }

    private boolean solveSudoku(char[][] board, int index) {
        if (index >= 81) {
            return true;
        }

        Index rowCol = convert(index);
        if (board[rowCol.row][rowCol.col] == '.') {
            for (char number = '1'; number <= '9'; number++) {
                board[rowCol.row][rowCol.col] = number;
                if (isValidSudoku(board) && solveSudoku(board, index + 1)) {
                    return true;
                }
            }
            board[rowCol.row][rowCol.col] = '.';
            return false;
        } else {
            return solveSudoku(board, index + 1);
        }
    }

    private boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        } else {
            return isCharValid(board) && isLineValid(board, true) &&
                isLineValid(board, false) && isCubeValid(board);
        }
    }

    private boolean isCharValid(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char character = board[i][j];
                if (character != '.' && (character < '1' || character > '9')) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isLineValid(char[][] board, boolean horizontal) {
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char character = horizontal ? board[i][j] : board[j][i];
                if (character != '.' && charSet.contains(character)) {
                    return false;
                } else {
                    charSet.add(character);
                }
            }
            charSet.clear();
        }
        return true;
    }

    private boolean isCubeValid(char[][] board) {
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        char character = board[i + row][j + col];
                        if (character != '.' && charSet.contains(character)) {
                            return false;
                        } else {
                            charSet.add(character);
                        }
                    }
                }
                charSet.clear();
            }
        }
        return true;
    }

    private Index convert(int index) {
        return new Index(index / 9, index % 9);
    }

    private class Index {
        int row;
        int col;

        Index(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
