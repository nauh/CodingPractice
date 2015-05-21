public class HouseRobberII implements Runnable {

    @Override
    public void run() {
        int[] nums = new int[] {2, 1, 1, 1};
        System.out.println(rob(nums));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int[] currentStolen = new int[2];
        int[] currentUnstolen = new int[2];
        currentStolen[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int money = nums[i];
            int previousStolen = currentStolen[0];
            int previousUnstolen = currentUnstolen[0];
            currentStolen[0] = previousUnstolen + money;
            currentUnstolen[0] = Math.max(previousUnstolen, previousStolen);
            if (i < nums.length - 1) {
                previousStolen = currentStolen[1];
                previousUnstolen = currentUnstolen[1];
                currentStolen[1] = previousUnstolen + money;
                currentUnstolen[1] = Math.max(previousUnstolen, previousStolen);
            }
        }
        return Math.max(Math.max(currentStolen[0], currentUnstolen[0]), Math.max(currentStolen[1], currentUnstolen[1]));
    }

}
