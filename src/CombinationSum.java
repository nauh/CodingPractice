import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum implements Runnable {

    @Override
    public void run() {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum(candidates, candidates.length - 1, target);
    }

    private List<List<Integer>> combinationSum(int[] candidates, int current, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (current < 0 || target < 0) {
            return result;
        }

        int number = candidates[current];
        if (target % number == 0) {
            List<Integer> combination = new ArrayList<>(target / number);
            for (int i = 0; i < target / number; i++) {
                combination.add(number);
            }
            result.add(combination);
        }

        int count = 0;
        while (target > 0) {
            for (List<Integer> combination : combinationSum(candidates, current - 1, target)) {
                for (int i = 0; i < count; i++) {
                    combination.add(number);
                }
                result.add(combination);
            }
            target -= number;
            count++;
        }
        return result;
    }

}
