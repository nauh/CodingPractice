import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber implements Runnable {

    @Override
    public void run() {
        int[] nums = new int[] {824,938,1399,5607,6973,5703,9609,4398,8247};
        System.out.println(largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] numbers = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numbers, new Comparator<String>() {
            @Override
            public int compare(String left, String right) {
                String leftRight = left.concat(right);
                String rightLeft = right.concat(left);
                return rightLeft.compareTo(leftRight);
            }
        });
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            result.append(numbers[i]);
        }
        if (result.charAt(0) == '0') {
            return "0";
        } else {
            return result.toString();
        }
    }

}
