import java.util.StringJoiner;

public class FirstMissingPositive implements Runnable {

    @Override
    public void run() {
        System.out.println(firstMissingPositive(new int[] {-3,-4,1,2}));
    }

    public int firstMissingPositive(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (A[i] == i + 1) {
                i++;
            } else if (A[i] - 1 >= 0 && A[i] - 1 < A.length && A[i] != A[A[i] - 1]) {
                swap(A, i, A[i] - 1);
            } else {
                i++;
            }
        }
        for (i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }

    private void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }

    private void print(int[] A) {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (int i = 0; i < A.length; i++) {
            stringJoiner.add(Integer.toString(A[i]));
        }
        System.out.println(stringJoiner.toString());
    }

}
