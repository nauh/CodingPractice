import java.util.LinkedList;
import java.util.List;

public class SurroundedRegions implements Runnable {

    @Override
    public void run() {
        char[][] board = new char[][] {{'O', 'O'}, {'O', 'O'}};
        solve(board);
    }

    public void solve(char[][] board) {
        if (board == null || board.length <= 0 || board[0].length <= 0) {
            return;
        }
        for (int col = 0; col < board[0].length; col++) {
            modify(board, 0, col);
            modify(board, board.length - 1, col);
        }
        for (int row = 0; row < board.length; row++) {
            modify(board, row, 0);
            modify(board, row, board[0].length - 1);
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == 'Y') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    private void modify(char[][] board, int rowIndex, int colIndex) {
        List<Integer> queue = new LinkedList<>();
        queue.add(rowIndex * board[0].length + colIndex);
        while (!queue.isEmpty()) {
            int index = queue.remove(0);
            int row = index / board[0].length;
            int col = index % board[0].length;
            if (board[row][col] == 'O') {
                board[row][col] = 'Y';
                if (inBound(board, row + 1, col)) {
                    queue.add((row + 1) * board[0].length + col);
                }
                if (inBound(board, row - 1, col)) {
                    queue.add((row - 1) * board[0].length + col);
                }
                if (inBound(board, row, col + 1)) {
                    queue.add(row * board[0].length + col + 1);
                }
                if (inBound(board, row, col - 1)) {
                    queue.add(row * board[0].length + col - 1);
                }
            }
        }
    }

    private boolean inBound(char[][] board, int row, int col) {
        return 0 <= row && row < board.length && 0 <= col && col < board[0].length;
    }
}
