public class UniquePaths implements Runnable {

    @Override
    public void run() {
    }

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[][] results = new int[m][n];
        for (int row = 0; row < m; row++) {
            results[row][n - 1] = 1;
        }
        for (int col = 0; col < n; col++) {
            results[m - 1][col] = 1;
        }

        for (int col = n - 2; col >= 0; col--) {
            for (int row = m - 2; row >= 0; row--) {
                results[row][col] = results[row + 1][col] + results[row][col + 1];
            }
        }
        return results[0][0];
    }

}
