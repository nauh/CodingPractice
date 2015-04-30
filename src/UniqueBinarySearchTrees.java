public class UniqueBinarySearchTrees implements Runnable {

    @Override
    public void run() {
        System.out.println(numTrees(3));
    }

    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                result[i] += result[j] * result[i - j - 1];
            }
        }
        return result[n];
    }

    public int recursiveNumTrees(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int result = 0;
            for (int i = 0; i < n; i++) {
                int left = numTrees(i);
                int right = numTrees(n - i - 1);
                if (left == 0 || right == 0) {
                    result += left + right;
                } else {
                    result += left * right;
                }
            }
            return result;
        }
    }

}
