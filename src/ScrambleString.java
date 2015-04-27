public class ScrambleString implements Runnable {

    @Override
    public void run() {
    }

    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.isEmpty() && s2.isEmpty()) {
            return true;
        }

        int length = s1.length();
        boolean[][][] result = new boolean[length][length][length + 1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                result[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int k = 2; k <= length; k++) {
            for (int i = 0; i < length - k + 1; i++) {
                for (int j = 0; j < length - k + 1; j++) {
                    for (int split = 1; split < k; split++) {
                        result[i][j][k] |= (result[i][j][split] && result[i + split][j + split][k - split])
                            || (result[i][j + k - split][split] && result[i + split][j][k - split]);
                    }
                }
            }
        }
        return result[0][0][length];
    }

}
