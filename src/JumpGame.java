import java.util.List;

public class JumpGame implements Runnable {

    @Override
    public void run() {
    }

    public boolean canJump(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return true;
        }
        int destination = nums.size() - 1;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums.get(i) + i >= destination) {
                destination = i;
            }
        }
        return destination == 0;
    }

}
