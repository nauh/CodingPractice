import java.util.Arrays;

public class NextPermutation implements Runnable {

    @Override
    public void run() {

    }

    public void nextPermutation(int[] num) {
        int index = findLastAscendingPair(num);
        if (index < 0) {
            flip(num, 0, num.length - 1);
            return;
        }

        swap(num, index, findNextMinimumGreater(num, index + 1, num[index]));
        flip(num, index + 1, num.length - 1);
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    private int findLastAscendingPair(int[] num) {
        if (num.length < 2) {
            return -1;
        }

        for (int i = num.length - 1; i > 0; i--) {
            if (num[i - 1] < num[i]) {
                return i - 1;
            }
        }

        return -1;
    }

    private int findNextMinimumGreater(int[] num, int start, int pivot) {
        int result = -1;
        int currentMinimum = Integer.MAX_VALUE;
        for (int i = start; i < num.length; i++) {
            if (num[i] > pivot && num[i] <= currentMinimum) {
                result = i;
                currentMinimum = num[i];
            }
        }
        return result;
    }

    private void flip(int[] num, int start, int end) {
        while (start < end) {
            swap(num, start, end);
            start++;
            end--;
        }
    }

}
