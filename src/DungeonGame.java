public class DungeonGame implements Runnable {

    @Override
    public void run() {

    }

    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int column = dungeon[0].length;
        int minimumHP[][] = new int[row][column];
        minimumHP[row - 1][column - 1] = Math.max(0, 0 - dungeon[row - 1][column - 1]);

        int lastColumn = column - 1;
        for (int i = row - 2; i >= 0; i--) {
            minimumHP[i][lastColumn] = Math.max(0, minimumHP[i + 1][lastColumn] - dungeon[i][lastColumn]);
        }

        int lastRow = row - 1;
        for (int j = column - 2; j >= 0; j--) {
            minimumHP[lastRow][j] = Math.max(0, minimumHP[lastRow][j + 1] - dungeon[lastRow][j]);
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = column - 2; j>= 0; j--) {
                minimumHP[i][j] = Math.max(0, Math.min(minimumHP[i + 1][j], minimumHP[i][j + 1]) - dungeon[i][j]);
            }
        }
        return minimumHP[0][0] + 1;
    }

}
