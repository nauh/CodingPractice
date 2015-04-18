import java.util.ArrayList;
import java.util.List;

public class PermutationSequence implements Runnable {

    @Override
    public void run() {
        System.out.println(getPermutation(3, 2));
    }

    public String getPermutation(int n, int k) {
        List<Integer> digits = new ArrayList<>();
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
            digits.add(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            int level = (k - 1) / factorial[i - 1];
            sb.append(digits.get(level));
            digits.remove(level);
            k -= level * factorial[i - 1];
        }
        return sb.toString();
    }

}
