import java.util.HashMap;
import java.util.Map;

public class MajorityElement implements Runnable {

    @Override
    public void run() {
    }

    public int majorityElement(int[] nums) {
        // assume array is non-empty
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) > nums.length / 2) {
                return key;
            }
        }
        return 0;
    }

}
