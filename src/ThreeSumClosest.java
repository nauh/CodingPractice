import java.util.Arrays;

public class ThreeSumClosest implements Runnable {

    @Override
    public void run() {
    }

    public int threeSumClosest(int[] num, int target) {
        if (num.length <= 3) {
            int closestSum = 0;
            for (int i = 0; i < num.length; i++) {
                closestSum += num[i];
            }
            return closestSum;
        }

        Arrays.sort(num);
        int closestSum = num[0] + num[num.length / 2] + num[num.length - 1];
        int minDifference = Math.abs(closestSum - target);
        for (int i = 0; i < num.length - 2; i++) {
            int pivotNum = num[i];
            int start = i + 1;
            int end = num.length - 1;
            while (start < end) {
                int threeSum = pivotNum + num[start] + num[end];
                if (threeSum == target) {
                    return target;
                }

                int difference = Math.abs(threeSum - target);
                if (difference < minDifference) {
                    minDifference = difference;
                    closestSum = threeSum;
                }
                if (threeSum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return closestSum;
    }

}
