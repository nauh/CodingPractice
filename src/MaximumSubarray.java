import java.util.List;

public class MaximumSubarray implements Runnable {

    @Override
    public void run() {
    }

    public int maxSubArray(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int maximum = Integer.MIN_VALUE, maxStart = -1, maxEnd = -1;
        int current = Integer.MIN_VALUE, curStart = -1, curEnd = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (current <= 0) {
                curStart = i;
                curEnd = i;
                current = nums.get(i);
            } else {
                current += nums.get(i);
                curEnd = i;
            }
            if (current >= maximum) {
                maximum = current;
                maxStart = curStart;
                maxEnd = curEnd;
            }
        }
        return maximum;
    }

}
