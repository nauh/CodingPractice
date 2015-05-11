import java.util.ArrayList;
import java.util.List;


public class PalindromePartitioning implements Runnable {

    @Override
    public void run() {
        System.out.println(partition("amanaplanacanalpanama"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
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
        helper(result, new ArrayList<String>(), s, 0, palindrome);
        return result;
    }

    private void helper(List<List<String>> result, List<String> current, String s, int start, boolean[][] palindrome) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            if (palindrome[start][i] == true) {
                current.add(s.substring(start, i));
                helper(result, current, s, i, palindrome);
                current.remove(current.size() - 1);
            }
        }
    }

}
