import java.util.HashSet;
import java.util.Set;

public class HappyNumber implements Runnable {

    @Override
    public void run() {
    }

    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        Set<Integer> seen = new HashSet<>();
        while (!seen.contains(n)) {
            seen.add(n);
            int number = 0;
            while (n > 0) {
                int digit = n % 10;
                number += digit * digit;
                n /= 10;
            }
            n = number;
        }
        return n == 1;
    }

}
