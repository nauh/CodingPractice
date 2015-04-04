public class RemoveDuplicatesFromSortedArray implements Runnable {

    @Override
    public void run() {
        System.out.println(removeDuplicates(new int[] {1, 2, 2, 3, 4}));
    }

    public int removeDuplicates(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int current = A[0];
        int tail = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != current) {
                current = A[i];
                A[++tail] = A[i];
            }
        }
        return tail + 1;
    }

}
