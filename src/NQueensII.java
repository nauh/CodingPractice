import java.util.ArrayList;
import java.util.List;

public class NQueensII implements Runnable {

    @Override
    public void run() {
        System.out.println(totalNQueens(4));
    }

    public int totalNQueens(int n) {
        List<String[]> result = new ArrayList<>();
        if (n <= 0) {
            return 0;
        }
        helper(n, 0, new int[n], result);
        return result.size();
    }

    private void helper(int n, int row, int[] colForRow, List<String[]> result) {
        if (row == n) {
            result.add(make(colForRow));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, colForRow)) {
                colForRow[row] = col;
                helper(n, row + 1, colForRow, result);
            }
        }
    }

    private boolean isValid(int row, int col, int[] colForRow) {
        for (int i = 0; i < row; i++) {
            if (col == colForRow[i] || Math.abs(col - colForRow[i]) == row - i) {
                return false;
            }
        }
        return true;
    }

    private String[] make(int[] colForRow) {
        String[] result = new String[colForRow.length];
        for (int row = 0; row < colForRow.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < colForRow.length; col++) {
                sb.append(col == colForRow[row] ? "Q" : ".");
            }
            result[row] = sb.toString();
        }
        return result;
    }

}
