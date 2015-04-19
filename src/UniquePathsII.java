public class UniquePathsII implements Runnable {

    @Override
    public void run() {
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }

        int rowCount = obstacleGrid.length, colCount = obstacleGrid[0].length;
        int[][] results = new int[rowCount][colCount];
        boolean obstacleHit = false;
        for (int row = rowCount - 1; row >= 0; row--) {
            obstacleHit = obstacleHit || (obstacleGrid[row][colCount - 1] == 1);
            results[row][colCount - 1] = obstacleHit ? 0 : 1;
        }
        obstacleHit = false;
        for (int col = colCount - 1; col >= 0; col--) {
            obstacleHit = obstacleHit || (obstacleGrid[rowCount - 1][col] == 1);
            results[rowCount - 1][col] = obstacleHit ? 0 : 1;
        }

        for (int col = colCount - 2; col >= 0; col--) {
            for (int row = rowCount - 2; row >= 0; row--) {
                results[row][col] = obstacleGrid[row][col] == 1 ?
                    0 : results[row + 1][col] + results[row][col + 1];
            }
        }
        return results[0][0];
    }

}
