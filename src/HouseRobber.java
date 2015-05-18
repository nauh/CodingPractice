public class HouseRobber implements Runnable {

    @Override
    public void run() {
        int[] nums = new int[] {2, 1, 1, 2};
        System.out.println(rob(nums));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int currentStolen = 0, currentUnstolen = 0;
        for (int i = 0; i < nums.length; i++) {
            int prevStolen = currentStolen;
            currentStolen = currentUnstolen + nums[i];
            currentUnstolen = Math.max(prevStolen, currentUnstolen);
        }
        return Math.max(currentStolen, currentUnstolen);
    }

}
