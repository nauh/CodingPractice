import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII implements Runnable {

    @Override
    public void run() {
        int[] candidates = new int[] {1, 1};
        System.out.println(combinationSum2(candidates, 1));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum(int[] candidates, int target, int currentIndex,
        List<Integer> currentPath, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentPath));
            return;
        }
        for (int i = currentIndex; i < candidates.length; i = next(candidates, i)) {
            if (target < candidates[i]) {
                return;
            }
            currentPath.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i + 1, currentPath, result);
            currentPath.remove(currentPath.size() - 1);
        }
        return;
    }

    private int next(int[] candidates, int current) {
        int number = candidates[current];
        while (current + 1 < candidates.length) {
            if (candidates[current + 1] != number) {
                return current + 1;
            } else {
                current++;
            }
        }
        return candidates.length;
    }

}
