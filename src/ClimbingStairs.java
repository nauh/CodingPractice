public class ClimbingStairs implements Runnable {

    @Override
    public void run() {

    }

    public int climbStairs(int n) {
        int result = 1;
        int minusTwo = 1;
        int minusOne = 1;
        for (int i = 2; i <= n; i++) {
            result = minusTwo + minusOne;
            minusTwo = minusOne;
            minusOne = result;
        }
        return result;
    }
}
