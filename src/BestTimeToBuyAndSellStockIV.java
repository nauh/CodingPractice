import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndSellStockIV implements Runnable {

    @Override
    public void run() {
        System.out.println(maxProfit(2, new int[] {2,6,8,7,8,7,9,4,1,2,4,5,8}));
    }

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 1 || k <= 0) {
            return 0;
        }

        List<Integer> profits = new ArrayList<>();
        for (int i = 0; i < prices.length - 1; i++) {
            int change = prices[i + 1] - prices[i];
            int lastProfit = profits.isEmpty() ? 0 : profits.get(profits.size() - 1);
            if (!profits.isEmpty() && ((lastProfit > 0 && change > 0) || (lastProfit <= 0 && change <= 0))) {
                profits.set(profits.size() - 1, lastProfit + change);
            } else {
                profits.add(change);
            }
        }

        // remove deficits at the beginning and the end
        if (!profits.isEmpty() && profits.get(0) <= 0) {
            profits.remove(0);
        }
        if (!profits.isEmpty() && profits.get(profits.size() - 1) <= 0) {
            profits.remove(profits.size() - 1);
        }

        while (k < (profits.size() + 1) / 2) { // (profits.size() + 1) / 2 is the number of positive profits
            int minDeficitIndex = findMinDeficit(profits);
            int minProfitIndex = findMinProfit(profits);
            if (Math.abs(profits.get(minProfitIndex)) > Math.abs(profits.get(minDeficitIndex))) {
                profits.set(minDeficitIndex - 1, profits.get(minDeficitIndex - 1) + profits.get(minDeficitIndex) + profits.get(minDeficitIndex + 1));
                profits.remove(minDeficitIndex + 1);
                profits.remove(minDeficitIndex);
            } else {
                if (minProfitIndex == 0) {
                    profits.remove(minProfitIndex + 1);
                    profits.remove(minProfitIndex);
                } else if (minProfitIndex == profits.size() - 1) {
                    profits.remove(minProfitIndex);
                    profits.remove(minProfitIndex - 1);
                } else {
                    profits.set(minProfitIndex - 1, profits.get(minProfitIndex - 1) + profits.get(minProfitIndex) + profits.get(minProfitIndex + 1));
                    profits.remove(minProfitIndex + 1);
                    profits.remove(minProfitIndex);
                }
            }
        }

        int result = 0;
        for (Integer profit : profits) {
            if (profit > 0) {
                result += profit;
            }
        }
        return result;
    }

    private int findMinDeficit(List<Integer> profits) {
        int result = -1;
        int minDeficit = Integer.MIN_VALUE;
        for (int i = 0; i < profits.size(); i++) {
            int current = profits.get(i);
            if (current <= 0 && current > minDeficit) {
                minDeficit = current;
                result = i;
            }
        }
        return result;
    }

    private int findMinProfit(List<Integer> profits) {
        int result = -1;
        int minProfit = Integer.MAX_VALUE;
        for (int i = 0; i < profits.size(); i++) {
            int current = profits.get(i);
            if (current > 0 && current < minProfit) {
                minProfit = current;
                result = i;
            }
        }
        return result;
    }

}
