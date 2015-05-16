public class MaximumProductSubarray implements Runnable {

    @Override
    public void run() {
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0], local = nums[0];
        int firstNegative = local < 0 ? local : 0;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                local = 0;
                firstNegative = 0;
                max = Math.max(max, local);
            } else {
                local = local == 0 ? num : local * num;
                if (local < 0) {
                    if (firstNegative >= 0) {
                        firstNegative = local;
                        max = Math.max(max, local);
                    } else {
                        max = Math.max(max, local / firstNegative);
                    }
                } else {
                    max = Math.max(max, local);
                }
            }
        }
        return max;
    }
}
