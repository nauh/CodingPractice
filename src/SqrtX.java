public class SqrtX implements Runnable {

    @Override
    public void run() {
        System.out.println(mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int start = 0;
        int end = x;
        while (start < end) {
            int middle = (start + end) / 2;
            int ratio = x / middle;
            if (ratio < middle) {
                end = middle - 1;
            } else if (ratio > middle) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return Math.min(start, x / start);
    }

}
