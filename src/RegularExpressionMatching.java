public class RegularExpressionMatching implements Runnable {

    @Override
    public void run() {
        String string = "aaa";
        String pattern = "ab*ac*a";
        System.out.println(isMatch(string, pattern));
    }

    public boolean isMatch(String string, String pattern) {
        if (pattern.length() == 0) {
            return string.length() == 0;
        } else if (pattern.length() == 1 || pattern.charAt(1) != '*') {
            return string.length() >= 1
                && isMatch(string.charAt(0), pattern.charAt(0))
                && isMatch(string.substring(1), pattern.substring(1));
        } else {
            if (isMatch(string, pattern.substring(2))) {
                return true;
            }
            for (int i = 0; i < string.length() && isMatch(string.charAt(i), pattern.charAt(0)); i++) {
                if (isMatch(string.substring(i + 1), pattern.substring(2))) {
                    return true;
                }
            }
            return false;
        }

    }

    boolean isMatch(char character, char pattern) {
        return pattern == '.' || pattern == character;
    }

}
