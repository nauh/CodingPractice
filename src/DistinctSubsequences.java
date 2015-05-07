public class DistinctSubsequences implements Runnable {

    @Override
    public void run() {
        System.out.println(numDistinct("","a"));
    }

    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return -1;
        }

        int[][] stats = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            stats[i][0] = 1;
        }
        for (int j = 1; j <= t.length(); j++) {
            for (int i = 1; i <= s.length(); i++) {
                stats[i][j] = stats[i - 1][j] + (s.charAt(i - 1) == t.charAt(j - 1) ? stats[i - 1][j - 1] : 0);
            }
        }
        return stats[s.length()][t.length()];
    }

}
