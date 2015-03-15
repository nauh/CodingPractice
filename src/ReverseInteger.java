public class ReverseInteger implements Runnable {

    @Override
    public void run() {
        System.out.println(reverse(123));
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            // Math.abs(Integer.MAX_VALUE / 10) equals to Math.abs(Integer.MIN_VALUE / 10)
            if (Math.abs(Integer.MAX_VALUE / 10) < Math.abs(result)) {
                return 0;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }

        return result;
    }

}
