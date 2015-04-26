import java.util.Set;
import java.util.HashSet;

public class WordSearch implements Runnable {

    @Override
    public void run() {
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.isEmpty()) {
            return false;
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (helper(board, row, col, new HashSet<Integer>(), 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int row, int col, Set<Integer> path, int current, String word) {
        boolean result;
        if (current == word.length()) {
            result = true;
        } else {
            int trackingIndex = row * board[0].length + col;
            if (inBoundary(board, row, col) && board[row][col] == word.charAt(current) && !path.contains(trackingIndex)) {
                path.add(trackingIndex);
                result = helper(board, row - 1, col, path, current + 1, word)
                    || helper(board, row + 1, col, path, current + 1, word)
                    || helper(board, row, col - 1, path, current + 1, word)
                    || helper(board, row, col + 1, path, current + 1, word);
                path.remove(trackingIndex);
            } else {
                result = false;
            }
        }
        return result;
    }

    private boolean inBoundary(char[][] board, int row, int col) {
        return 0 <= row && row < board.length && 0 <= col && col < board[0].length;
    }
}
