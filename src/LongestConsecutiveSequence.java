import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence implements Runnable {

    @Override
    public void run() {
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (Integer num : nums) {
            numSet.add(num);
        }
        int currentLength = 0;
        int maxLength = 0;
        for (Integer num : nums) {
            if (numSet.contains(num)) {
                currentLength = 1;
                numSet.remove(num);
                for (int i = 1; numSet.contains(num - i); i++) {
                    currentLength++;
                    numSet.remove(num - i);
                }
                for (int i = 1; numSet.contains(num + i); i++) {
                    currentLength++;
                    numSet.remove(num + i);
                }
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            }
        }
        return maxLength;
    }

}
