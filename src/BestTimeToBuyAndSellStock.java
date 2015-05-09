public class BestTimeToBuyAndSellStock implements Runnable {

    @Override
    public void run() {
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) {
            return 0;
        }
        int max = 0;
        int current = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            current += prices[i + 1] - prices[i];
            if (current > max) {
                max = current;
            }
            if (current < 0) {
                current = 0;
            }
        }
        return max;
    }

}
