import java.util.ArrayList;
import java.util.List;

public class Combinations implements Runnable {

    @Override
    public void run() {
        System.out.println(combine(10, 7));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || n < k) {
            return result;
        }
        helper(n, k, 1, new ArrayList<Integer>(), result);
        return result;
    }

    private void helper(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n; i++) {
            current.add(i);
            helper(n, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

}
