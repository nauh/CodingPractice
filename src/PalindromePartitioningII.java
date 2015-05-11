import java.util.Arrays;

public class PalindromePartitioningII implements Runnable {

    @Override
    public void run() {
        System.out.println(minCut("eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj"));
    }

    public int minCut(String s) {
        int result = 0;
        if (s == null || s.isEmpty()) {
            return result;
        }
        boolean[][] palindrome = new boolean[s.length() + 1][s.length() + 1];
        for (int length = 0; length <= 1; length++) {
            for (int i = 0; i < s.length(); i++) {
                palindrome[i][i + length] = true;
            }
        }
        for (int length = 2; length <= s.length(); length++) {
            for (int i = 0; i <= s.length() - length; i++) {
                if (s.charAt(i) == s.charAt(i + length - 1)) {
                    palindrome[i][i + length] = palindrome[i + 1][i + length - 1];
                }
            }
        }
        int[] minCut = new int[s.length() + 1];
        Arrays.fill(minCut, s.length() - 1);
        minCut[0] = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (palindrome[i][j]) {
                    minCut[j] = Math.min(minCut[j], minCut[i] + 1);
                }
            }
        }
        return minCut[s.length()];
    }

}
