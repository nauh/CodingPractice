public class FindMinimumInRotatedSortedArrayII implements Runnable {

    @Override
    public void run() {
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            if (nums[start] < nums[end]) {
                return nums[start];
            } else {
                int middle = (start + end) / 2;
                if (nums[start] > nums[middle]) {
                    end = middle;
                } else if (nums[middle] > nums[end]) {
                    start = middle;
                } else {
                    start++;
                    end--;                    
                }
            }
        }
        return Math.min(nums[start], nums[end]);
    }

}
