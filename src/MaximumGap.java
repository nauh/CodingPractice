public class MaximumGap implements Runnable {

    @Override
    public void run() {
        System.out.println(maximumGap(new int[] {3, 6, 9, 1}));
    }

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        int bucketWidth = Math.max(1, (max - min) / (nums.length - 1));
        int bucketCount = (max - min) / bucketWidth + 1;
        int[] bucketMax = new int[bucketCount];
        int[] bucketMin = new int[bucketCount];
        for (int i = 0; i < nums.length; i++) {
            int bucketIndex = (nums[i] - min) / bucketWidth;
            bucketMax[bucketIndex] = Math.max(bucketMax[bucketIndex], nums[i]);
            bucketMin[bucketIndex] = bucketMin[bucketIndex] == 0 ? nums[i] : Math.min(bucketMin[bucketIndex], nums[i]);
        }

        int maxGap = 0;
        int lastBucketMax = bucketMax[0];
        for (int i = 1; i < bucketCount; i++) {
            if (bucketMax[i] == 0) {
                continue;
            }
            maxGap = Math.max(maxGap, bucketMin[i] - lastBucketMax);
            lastBucketMax = bucketMax[i];
        }
        return maxGap;
    }

}
