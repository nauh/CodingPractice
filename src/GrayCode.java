import java.util.ArrayList;
import java.util.List;

public class GrayCode implements Runnable {

    @Override
    public void run() {
    }

    public List<Integer> grayCode(int n) {
        if (n <= 0) {
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }
        List<Integer> result = grayCode(n - 1);
        List<Integer> temp = new ArrayList<>(result.size());
        for (int number : result) {
            temp.add(0, number + (int) Math.pow(2, n - 1));
        }
        result.addAll(temp);
        return result;
    }

}
