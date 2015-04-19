public class MinimumPathSum implements Runnable {

    @Override
    public void run() {
    }

    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return -1;
        }

        int rowCount = grid.length, colCount = grid[0].length;
        int[][] results = new int[rowCount][colCount];
        results[rowCount - 1][colCount - 1] = grid[rowCount - 1][colCount - 1];
        for (int row = rowCount - 2; row >= 0; row--) {
            results[row][colCount - 1] = grid[row][colCount - 1] + results[row + 1][colCount - 1];
        }
        for (int col = colCount - 2; col >= 0; col--) {
            results[rowCount - 1][col] = grid[rowCount - 1][col] + results[rowCount - 1][col + 1];
        }

        for (int col = colCount - 2; col >= 0; col--) {
            for (int row = rowCount - 2; row >= 0; row--) {
                results[row][col] = grid[row][col] + Math.min(results[row + 1][col], results[row][col + 1]);
            }
        }
        return results[0][0];
    }

}
