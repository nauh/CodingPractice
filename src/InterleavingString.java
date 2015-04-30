public class InterleavingString implements Runnable {

    @Override
    public void run() {
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        boolean result;
        if (s1 == null) {
            result = s2 != null && s2.equals(s3);
        } else if (s2 == null) {
            result = s1 != null && s1.equals(s3);
        } else if (s1.length() + s2.length() != s3.length()) {
            result = false;
        } else {
            boolean[][] results = new boolean[s1.length() + 1][s2.length() + 1];
            results[0][0] = true;
            for (int i = 1; i <= s1.length(); i++) {
                results[i][0] = results[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            }
            for (int j = 1; j <= s2.length(); j++) {
                results[0][j] = results[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
            }
            for (int i = 1; i <= s1.length(); i++) {
                for (int j = 1; j <= s2.length(); j++) {
                    results[i][j] = (results[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (results[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
            result = results[s1.length()][s2.length()];
        }
        return result;
    }

}
