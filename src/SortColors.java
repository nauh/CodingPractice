public class SortColors implements Runnable {

    @Override
    public void run() {

    }

    public void sortColors(int[] A) {
        if (A == null || A.length <= 1) {
            return;
        }

        int current = 0, nextZero = 0, end = A.length - 1;
        while (current <= end) {
            if (A[current] == 0) {
                swap(A, current++, nextZero++);
            } else if (A[current] == 1) {
                current++;
            } else {
                swap(A, current, end--);
            }
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
