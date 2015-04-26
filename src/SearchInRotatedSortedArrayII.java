public class SearchInRotatedSortedArrayII implements Runnable {

    @Override
    public void run() {
        System.out.println(search(new int[] {1,3}, 3));
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) {
                return true;
            }
            if (nums[start] < nums[middle]) {
                if (nums[start] <= target && target < nums[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            } else if (nums[middle] < nums[start]) {
                if (nums[middle] < target && target <= nums[end]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            } else {
                start++;
            }
        }
        return false;
    }
    
}
