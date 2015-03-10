import java.util.Map;
import java.util.HashMap;

public class TwoSum implements Runnable {

    @Override
    public void run() {
        System.out.println("Not implemented");
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numberMap.containsKey(numbers[i])) {
                result[0] = numberMap.get(numbers[i]) + 1;
                result[1] = i + 1;
            } else {
                numberMap.put(target - numbers[i], i);
            }
        }
        return result;
    }

}
