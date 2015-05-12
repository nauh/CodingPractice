public class SingleNumberII implements Runnable {

    @Override
    public void run() {
    }

    public int singleNumber(int[] nums) {
        if (nums == null && nums.length == 0) {
            return 0;
        }
        int ones = 0, twos = 0, threes = 0;
        for (int num : nums) {
            twos |= ones & num;
            ones ^= num;
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }

}
