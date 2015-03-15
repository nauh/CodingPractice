public class PalindromeNumber implements Runnable {

    @Override
    public void run() {
        System.out.println(isPalindrome(10201));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int divisor = 1;
        while (x / divisor >= 10) {
            divisor *= 10;
        }

        while (x > 0) {
            int firstDigit = x / divisor;
            int lastDigit = x % 10;
            if (firstDigit != lastDigit) {
                return false;
            }
            x = (x % divisor) / 10;
            divisor /= 100;
        }

        return true;
    }

}
