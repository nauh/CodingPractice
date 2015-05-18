public class BitwiseANDOfNumbersRange implements Runnable {

    @Override
    public void run() {
        System.out.println(rangeBitwiseAnd(5, 7));
    }

    public int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        int mBit = bits(m), nBit = bits(n);
        while (mBit == nBit && mBit > 0) {
            int base = 1 << (mBit - 1);
            result += base;
            m &= base - 1;
            n &= base - 1;
            mBit = bits(m);
            nBit = bits(n);
        }
        return result;
    }

    private int bits(int num) {
        int result = 0;
        while (num != 0) {
            result++;
            num = num >> 1;
        }
        return result;
    }

}
