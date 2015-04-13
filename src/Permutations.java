import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations implements Runnable {

    @Override
    public void run() {
    }

    public List<List<Integer>> permute(int[] num) {
        return permute(num, num.length - 1);
    }

    private List<List<Integer>> permute(int[] num, int end) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (end == 0) {
            resultList.add(Arrays.asList(num[0]));
        } else {
            int number = num[end];
            for (List<Integer> list : permute(num, end - 1)) {
                for (int i = 0; i <= list.size(); i++) {
                    List<Integer> result = new ArrayList<>(list);
                    result.add(i, number);
                    resultList.add(result);
                }
            }
        }
        return resultList;
    }

}
