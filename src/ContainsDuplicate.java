import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate implements Runnable {

    @Override
    public void run() {
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> numberSet = new HashSet<>();
        for (int num : nums) {
            if (numberSet.contains(num)) {
                return true;
            } else {
                numberSet.add(num);
            }
        }
        return false;
    }

}
