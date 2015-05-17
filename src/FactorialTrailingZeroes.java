public class FactorialTrailingZeroes implements Runnable {

    @Override
    public void run() {
    }

    public int trailingZeroes(int n) {
        int result = 0, current = n;
        while (current >= 5) {
            result += current / 5;
            current /= 5;
        }
        return result;
    }

}
