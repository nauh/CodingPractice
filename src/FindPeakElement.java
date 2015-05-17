public class FindPeakElement implements Runnable {

    @Override
    public void run() {
    }

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            int left = middle == 0 ? Integer.MIN_VALUE : nums[middle - 1];
            int right = middle == nums.length - 1 ? Integer.MIN_VALUE : nums[middle + 1];
            if (left > nums[middle]) {
                end = middle - 1;
            } else if (right > nums[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return Integer.MIN_VALUE;
    }

}
