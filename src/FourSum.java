import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FourSum implements Runnable {

    @Override
    public void run() {
    }

    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(num);

        Map<Integer, List<IndexPair>> twoSums = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int twoSum = num[i] + num[j];
                List<IndexPair> indexPairs = twoSums.containsKey(twoSum) ?
                    twoSums.get(twoSum) : new ArrayList<>();
                indexPairs.add(new IndexPair(i, j));
                twoSums.put(twoSum, indexPairs);
            }
        }

        Set<Integer> processedTwoSum = new HashSet<>();
        Set<Integer> processedResult = new HashSet<>();
        for (Integer twoSum : twoSums.keySet()) {
            int difference = target - twoSum;
            if (processedTwoSum.contains(twoSum) || !twoSums.containsKey(difference)) {
                continue;
            }

            for (IndexPair a : twoSums.get(twoSum)) {
                for (IndexPair b : twoSums.get(difference)) {
                    if (hasDuplicates(a, b)) {
                        continue;
                    }
                    List<Integer> numbers = new ArrayList<>();
                    numbers.add(num[a.left]);
                    numbers.add(num[a.right]);
                    numbers.add(num[b.left]);
                    numbers.add(num[b.right]);
                    Collections.sort(numbers);

                    int hashCode = numbers.hashCode();
                    if (!processedResult.contains(hashCode)) {
                        result.add(numbers);
                        processedResult.add(hashCode);
                    }
                }
            }

            processedTwoSum.add(twoSum);
            processedTwoSum.add(difference);
        }

        return result;
    }

    boolean hasDuplicates(IndexPair a, IndexPair b) {
        Set<Integer> indices = new HashSet<>();
        indices.add(a.left);
        indices.add(a.right);
        indices.add(b.left);
        indices.add(b.right);
        return indices.size() < 4;
    }
    class IndexPair {
        int left;
        int right;

        IndexPair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }


}
