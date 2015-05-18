public class CountPrimes implements Runnable {

    @Override
    public void run() {
        System.out.println(countPrimes(100));
    }

    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++) {
            primes[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (primes[i]) {
                for (int j = i + i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                result++;
            }
        }
        return result;
    }

}
