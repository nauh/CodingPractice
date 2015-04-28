import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class SubsetsII implements Runnable {

    @Override
    public void run() {
        System.out.println(subsets(new int[] {1,2,3,3}));
    }

    public List<List<Integer>> subsetsWithDup(int[] S) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        if (S == null) {
            return result;
        }
        Arrays.sort(S);
        helper(S, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void helper(int[] S, int start, List<Integer> current, List<List<Integer>> result) {
        if (!current.isEmpty()) {
            result.add(new ArrayList<Integer>(current));
        }
        for (int i = start; i < S.length; i++) {
            current.add(S[i]);
            helper(S, i + 1, current, result);
            current.remove(current.size() - 1);
            while (i + 1 < S.length && S[i] == S[i + 1]) {
                i++;
            }
        }
    }

}
