public class RotateArray implements Runnable {

    @Override
    public void run() {
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        k %= nums.length;
        // reverse all
        reverse(nums, 0, nums.length - 1);
        // reverse k
        reverse(nums, 0, k - 1);
        // reverse rest
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

}
