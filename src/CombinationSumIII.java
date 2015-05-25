import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII implements Runnable {

    @Override
    public void run() {
        System.out.println(combinationSum3(3, 9));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0 || n == 0) {
            return result;
        }
        helper(result, 1, n, k, 0, new ArrayList<Integer>());
        return result;
    }

    private void helper(List<List<Integer>> result, int start, int n, int k, int sum, List<Integer> current) {
        int size = current.size();
        if (size == k && sum == n) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (size < k && sum + i <= n) {
                current.add(i);
                helper(result, i + 1, n, k, sum + i, current);
                current.remove(current.size() - 1);
            }
        }
    }

}
