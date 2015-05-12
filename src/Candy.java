public class Candy implements Runnable {

    @Override
    public void run() {
    }

    public int candy(int[] ratings) {
        if (ratings == null) {
            return 0;
        }
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            } else {
                candy[i] = 1;
            }
        }
        int result = candy[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                if (candy[i] <= candy[i + 1]) {
                    candy[i] = Math.max(candy[i], candy[i + 1] + 1);
                }
            }
            result += candy[i];
        }
        return result;
    }

}
