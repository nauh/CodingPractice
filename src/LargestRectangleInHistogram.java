import java.util.Stack;

public class LargestRectangleInHistogram implements Runnable {

    @Override
    public void run () {
        int[] height = new int[] {0, 1, 0, 1};
        System.out.println(largestRectangleArea(height));
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

    public int slowLargestRectangleArea(int[] height) {
        if (height == null) {
            return 0;
        }

        int width = height.length;
        int[][] lowest = new int[width][width];
        for (int i = 0; i < width; i++) {
            lowest[i][i] = height[i];
        }
        for (int start = 0; start < width; start++) {
            for (int end = start + 1; end < width; end++) {
                lowest[start][end] = Math.min(lowest[start][end - 1], lowest[end][end]);
            }
        }

        int result = 0;
        for (int start = 0; start < width; start++) {
            for (int end = start; end < width; end++) {
                int area = lowest[start][end] * (end - start + 1);
                result = Math.max(result, area);
            }
        }
        return result;
    }

}
