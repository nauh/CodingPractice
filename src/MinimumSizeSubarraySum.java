public class MinimumSizeSubarraySum implements Runnable {

    @Override
    public void run() {
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0, start = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                result = result == 0 ? i - start + 1 : Math.min(result, i - start + 1);
                sum -= nums[start++];
            }
        }
        return result;
    }

}
