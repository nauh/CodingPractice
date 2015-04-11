public class SearchInsertPosition implements Runnable {

    @Override
    public void run() {
    }

    public int searchInsert(int[] A, int target) {
        if (A == null) {
            return 0;
        }

        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            int middle = (start + end) / 2;
            if (A[middle] < target) {
                start = middle + 1;
            } else if (A[middle] > target) {
                end = middle - 1;
            } else {
                return middle;
            }
        }

        if (A[start] >= target) {
            return start;
        } else {
            return start + 1;
        }
    }

}
