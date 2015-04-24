public class SearchA2DMatrix implements Runnable {

    @Override
    public void run() {
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }

        int start = 0, end = matrix.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (matrix[middle][0] < target) {
                if (matrix[middle][matrix[0].length - 1] < target) {
                    start = middle + 1;
                } else {
                    int i = 0, j = matrix[0].length - 1, row = middle;
                    while (i <= j) {
                        middle = i + (j - i) / 2;
                        if (matrix[row][middle] < target) {
                            i = middle + 1;
                        } else if (matrix[row][middle] > target) {
                            j = middle - 1;
                        } else {
                            return true;
                        }
                    }
                    return false;
                }
            } else if (matrix[middle][0] > target) {
                end = middle - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
