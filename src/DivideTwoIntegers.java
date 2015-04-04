public class DivideTwoIntegers implements Runnable {

    @Override
    public void run() {
        System.out.println(divide(Integer.MIN_VALUE, -1));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isPositive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        int result = 0;
        while(absDividend >= absDivisor) {
            int counter = 0;
            while (absDividend >= absDivisor << counter) {
                counter++;
            }
            result += 1 << (counter - 1);
            absDividend -= absDivisor << (counter - 1);
        }

        return isPositive ? result : 0 - result;
    }

}
