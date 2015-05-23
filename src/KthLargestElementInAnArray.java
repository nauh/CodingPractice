public class KthLargestElementInAnArray implements Runnable {

    @Override
    public void run() {
        int[] nums = new int[] {4,2,1,3,5};
        System.out.println(findKthLargest(nums, 1));
    }

    // quick select
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        for (int start = 0, end = nums.length - 1, target = k - 1;;) {
            int splitIndex = partition(nums, start, end);
            if (splitIndex < target) {
                start = splitIndex + 1;
            } else if (splitIndex > target) {
                end = splitIndex - 1;
            } else {
                result = nums[splitIndex];
                break;
            }
        }
        return result;
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int splitIndex = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] >= pivot) {
                swap(nums, ++splitIndex, i);
            }
        }
        swap(nums, ++splitIndex, end);
        return splitIndex;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
