import java.util.ArrayList;
import java.util.List;

public class Triangle implements Runnable {

    @Override
    public void run() {
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        int[] minimum = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                minimum[j] = triangle.get(i).get(j) + Math.min(minimum[j], minimum[j + 1]);
            }
        }
        return minimum[0];
    }

}
