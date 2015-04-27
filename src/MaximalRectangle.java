import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] histograms = new int[matrix.length][matrix[0].length];
        for (int col = 0; col < matrix[0].length; col++) {
            int prev = 0;
            for (int row = 0; row < matrix.length; row++) {
                histograms[row][col] = (matrix[row][col] == '1') ? prev + 1 : 0;
                prev = histograms[row][col];
            }
        }

        int result = 0;
        for (int row = 0; row < matrix.length; row++) {
            result = Math.max(result, largestRectangleArea(histograms[row]));
        }
        return result;
    }

    public int largestRectangleArea(int[] height) {
        if (height == null) {
            return 0;
        }

        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[i] <= height[stack.peek()]) {
                int index = stack.pop();
                int width = stack.empty() ? i : i - stack.peek() - 1;
                result = Math.max(result, height[index] * width);
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            int index = stack.pop();
            int width = stack.empty() ? height.length : height.length - stack.peek() - 1;
            result = Math.max(result, height[index] * width);
        }
        return result;
    }

}
