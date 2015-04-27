public class MergeSortedArray implements Runnable {

    @Override
    public void run() {
    }

    public void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null) {
            return;
        }
        int current = m + n - 1;
        while (m > 0 && n > 0) {
            int numA = A[m - 1];
            int numB = B[n - 1];
            if (numA < numB) {
                A[current] = numB;
                n--;
            } else {
                A[current] = numA;
                m--;
            }
            current--;
        }
        if (m > 0) {
            while (m > 0) {
                A[current] = A[m - 1];
                m--;
                current--;
            }
        } else if (n > 0) {
            while (n > 0) {
                A[current] = B[n - 1];
                n--;
                current--;
            }
        }
    }

}
