import java.util.Stack;

public class TrappingRainWater implements Runnable {

    @Override
    public void run() {
        System.out.println(trap(new int[] {4,2,3}));
    }

    public int trap(int[] A) {
        if (A == null || A.length <= 2) {
            return 0;
        }
        int result = 0;
        int difference = 0;
        Stack<Tuple> stack = new Stack<>();
        for (int i = 1; i < A.length; i++) {
            difference = A[i] - A[i - 1];
            if (difference < 0) {
                stack.push(new Tuple(0 - difference, i));
            } else if (difference > 0) {
                while (!stack.isEmpty() && difference > 0) {
                    Tuple tuple = stack.peek();
                    int currentHeight = Math.min(difference, tuple.difference);
                    result += currentHeight * (i - tuple.index);
                    difference -= currentHeight;
                    tuple.difference = tuple.difference - currentHeight;
                    if (tuple.difference <= 0) {
                        stack.pop();
                    }
                }
            } else {
                continue;
            }
        }
        return result;
    }

    class Tuple {
        int difference;
        int index;

        Tuple(int difference, int index) {
            this.difference = difference;
            this.index = index;
        }
    }

}
