import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndSellStockIII implements Runnable {

    @Override
    public void run() {
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) {
            return 0;
        }

        List<Integer> maxProfit = maxProfit(prices, 0, prices.length - 1);
        int max = maxProfit.get(0);
        int maxStart = maxProfit.get(1);
        int maxEnd = maxProfit.get(2);
        int leftMax = maxProfit(prices, 0, maxStart).get(0);
        int rightMax = maxProfit(prices, maxEnd, prices.length - 1).get(0);

        int maxDeficit = 0, curDeficit = 0;
        for (int i = maxStart; i < maxEnd; i++) {
            int change = prices[i + 1] - prices[i];
            curDeficit = change < 0 ? curDeficit + change : 0;
            if (curDeficit < maxDeficit) {
                maxDeficit = curDeficit;
            }
        }
        return max + Math.max(Math.max(leftMax, rightMax), Math.abs(maxDeficit));
    }

    public List<Integer> maxProfit(int[] prices, int start, int end) {
        List<Integer> result = new ArrayList<>();
        if (start >= end) {
            result.add(0);
            result.add(0);
            result.add(0);
            return result;
        }
        int max = 0, maxStart = 0, maxEnd = 0;
        int current = 0, curStart = 0;
        for (int i = start; i < end; i++) {
            current += prices[i + 1] - prices[i];
            if (current > max) {
                max = current;
                maxStart = curStart;
                maxEnd = i + 1;
            }
            if (current < 0) {
                current = 0;
                curStart = i + 1;
            }
        }
        result.add(max);
        result.add(maxStart);
        result.add(maxEnd);
        return result;
    }

}
