public class SearchForARange implements Runnable {

    @Override
    public void run() {
        int[] result = searchRange(new int[]{2, 2, 3}, 2);
        System.out.println(result[0] + ", " + result[1]);
    }

    public int[] searchRange(int[] A, int target) {
        int[] result = new int[] {-1, -1};
        if (A == null) {
            return result;
        }

        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (A[middle] < target) {
                start = middle + 1;
            } else if (A[middle] > target) {
                end = middle - 1;
            } else {
                if (middle == 0 || A[middle - 1] < target) {
                    result[0] = middle;
                    break;
                } else {
                    end = middle - 1;
                }
            }
        }

        end = A.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (A[middle] < target) {
                start = middle + 1;
            } else if (A[middle] > target) {
                end = middle - 1;
            } else {
                if (middle == A.length - 1 || A[middle + 1] > target) {
                    result[1] = middle;
                    break;
                } else {
                    start = middle + 1;
                }
            }
        }
        return result;
    }

}
