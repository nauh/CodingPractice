import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII implements Runnable {

    @Override
    public void run() {
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex < 0) {
            return result;
        }
        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            int prev = 0;
            for (int j = 0; j < i; j++) {
                int current = result.remove(0);
                result.add(prev + current);
                prev = current;
            }
            result.add(1);
        }
        return result;
    }

}
