import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class ThreeSome implements Runnable {

    @Override
    public void run() {
    }

    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new LinkedList<>();

        if (num.length < 3) {
            return result;
        }

        Arrays.sort(num);
        int i = 0;
        while (i >= 0 && i < num.length - 2) {
            int start = i + 1;
            int end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum == 0) {
                    result.add(Arrays.asList(num[i], num[start], num[end]));
                    start = slideToNext(num, start, true);
                    end = slideToNext(num, end, false);
                } else if (sum < 0) {
                    start = slideToNext(num, start, true);
                } else {
                    end = slideToNext(num, end, false);
                }
            }
            i = slideToNext(num, i, true);
        }
        return result;
    }

    int slideToNext(int[] num, int start, boolean ascending) {
        int index = start;
        int step = ascending ? 1 : -1;
        while (0 <= index && index < num.length) {
            if (num[index] != num[start]) {
                return index;
            }
            index += step;
        }
        return ascending ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    }

}
