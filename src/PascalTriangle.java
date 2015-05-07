import java.util.ArrayList;
import java.util.List;

public class PascalTriangle implements Runnable {

    @Override
    public void run() {
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows > 0) {
            result.add(new ArrayList<>());
            result.get(0).add(1);
            for (int i = 2; i <= numRows; i++) {
                List<Integer> toAdd = new ArrayList<>();
                toAdd.add(1);
                List<Integer> last = result.get(result.size() - 1);
                for (int j = 0; j < last.size() - 1; j++) {
                    toAdd.add(last.get(j) + last.get(j + 1));
                }
                toAdd.add(1);
                result.add(toAdd);
            }
        }
        return result;
    }

}
