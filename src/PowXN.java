public class PowXN implements Runnable {

    @Override
    public void run() {
        System.out.println(pow(34.00515, -3));
    }

    public double pow(double x, int n) {
        if (x == 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else {
            boolean flip = n < 0;
            double halfPow = pow(x, Math.abs(n) / 2);
            double factor = Math.abs(n) % 2 == 0 ? 1 : x;
            double intermediate = factor * halfPow * halfPow;
            return flip ? 1.0 / intermediate : intermediate;
        }
    }

}
