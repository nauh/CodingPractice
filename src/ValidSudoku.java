import java.util.HashSet;
import java.util.Set;

public class ValidSudoku implements Runnable {

    @Override
    public void run() {
        char[][] board = new char[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        board[0][4] = '5';
        board[0][7] = '1';
        board[1][1] = '4';
        board[1][3] = '3';
        board[2][5] = '3';
        board[2][8] = '1';
        board[3][0] = '8';
        board[3][7] = '2';
        board[4][2] = '2';
        board[4][4] = '7';
        board[5][1] = '1';
        board[5][2] = '5';
        board[6][5] = '2';
        board[7][1] = '2';
        board[7][3] = '9';
        board[8][2] = '4';

        System.out.println(isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
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

}
