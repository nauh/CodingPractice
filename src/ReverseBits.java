public class ReverseBits implements Runnable {

    @Override
    public void run() {
        System.out.println(Integer.toBinaryString(reverseBits(4)));
    }

    public int reverseBits(int n) {
        int result = 0;
        int mask = 1, modifier = Integer.MAX_VALUE;
        for (int i = 0; i < 32; i++) {
            int digit = n & mask;
            result = (result << 1) | (n & mask);
            n = n >> 1;
        }
        return result;
    }

}
