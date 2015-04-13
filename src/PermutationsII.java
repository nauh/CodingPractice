import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII implements Runnable {

    @Override
    public void run() {
        System.out.println(permuteUnique(new int[] {1, 2, 3, 4}));
    }

    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0)  {
            return result;
        }
        Arrays.sort(num);
        helper(num, new boolean[num.length], new ArrayList<Integer>(), result);
        return result;
    }

    private void helper(int[] num, boolean[] used, List<Integer> item, List<List<Integer>> result)  {
        if (item.size() == num.length) {
            result.add(new ArrayList<>(item));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                item.add(num[i]);
                helper(num, used, item, result);
                item.remove(item.size() - 1);
                used[i] = false;
            }
        }
    }

}
