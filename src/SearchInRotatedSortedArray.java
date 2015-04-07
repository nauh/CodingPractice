public class SearchInRotatedSortedArray implements Runnable {

    @Override
    public void run() {
        int[] input = new int[] {3,4,5,6,1,2};
        System.out.println(search(input, 3));
        System.out.println(search(input, 4));
        System.out.println(search(input, 5));
        System.out.println(search(input, 6));
        System.out.println(search(input, 1));
        System.out.println(search(input, 2));
    }

    public int search(int[] A, int target) {
        if (A == null) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (A[middle] == target) {
                return middle;
            }
            if (A[start] <= A[middle]) {
                if (A[start] <= target && target < A[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            } else {
                if (A[middle] < target && target <= A[end]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }
        return -1;
    }

}
