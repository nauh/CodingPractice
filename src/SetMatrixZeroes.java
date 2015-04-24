public class SetMatrixZeroes implements Runnable {

    @Override
    public void run() {
    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }

        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    rows[row] = true;
                    cols[col] = true;
                }
            }
        }

        for (int row = 0; row < rows.length; row++) {
            if (rows[row] == true) {
                for (int i = 0; i < cols.length; i++) {
                    matrix[row][i] = 0;
                }
            }
        }
        for (int col = 0; col < cols.length; col++) {
            if (cols[col] == true) {
                for (int i = 0; i < rows.length; i++) {
                    matrix[i][col] = 0;
                }
            }
        }
    }

}
