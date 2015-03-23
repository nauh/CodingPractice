import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses implements Runnable {

    @Override
    public void run() {
        print(generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis("", n, n, result);
        return result;
    }

    void generateParenthesis(String string, int left, int right, List<String> result) {
        if (right == 0) {
            result.add(string);
        } else if (left == 0) {
            generateParenthesis(string + ")", left, right - 1, result);
        } else if (left == right) {
            generateParenthesis(string + "(", left - 1, right, result);
        } else {
            generateParenthesis(string + "(", left - 1, right, result);
            generateParenthesis(string + ")", left, right - 1, result);
        }
        return;
    }

    void print(List<String> strings) {
        for (String string : strings) {
            System.out.println(string);
        }
    }

}
