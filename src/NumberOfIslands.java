public class NumberOfIslands implements Runnable {

    @Override
    public void run() {
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int result = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    result++;
                    mark(grid, row, col);
                }
            }
        }
        return result;
    }

    private void mark(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        if (grid[row][col] == '1') {
            grid[row][col] = 'X';
            mark(grid, row + 1, col);
            mark(grid, row - 1, col);
            mark(grid, row, col + 1);
            mark(grid, row, col - 1);
        }
    }

}
