public class RemoveElement implements Runnable {

    @Override
    public void run() {
    }

    public int removeElement(int[] A, int elem) {
        int tail = A.length - 1;
        int current = 0;
        while (current <= tail) {
            if (A[current] == elem) {
                swap(A, current, tail);
                tail--;
            } else {
                current++;
            }
        }
        return current;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
