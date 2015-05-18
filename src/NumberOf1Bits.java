public class NumberOf1Bits implements Runnable {

    @Override
    public void run() {
    }

    public int hammingWeight(int n) {
        int result = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            result += (n & mask) == 0 ? 0 : 1;
            n = n >> 1;
        }
        return result;
    }

}
