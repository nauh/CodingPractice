public class DecodeWays implements Runnable {

    @Override
    public void run() {
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) < '1' || s.charAt(0) > '9') {
            return 0;
        }
        int previous = 1;
        int result = 1;
        for (int i = 1; i < s.length(); i++) {
            char lastChar = s.charAt(i - 1);
            char current = s.charAt(i);
            int temp = result;
            if (!isDigit(current)) {
                return 0;
            } else if (current == '0') {
                if (tenOrTwenty(lastChar, current)) {
                    result = previous;
                } else {
                    return 0;
                }
            } else if (combinable(lastChar, current)) {
                result += previous;
            }
            previous = temp;
        }
        return result;
    }

    private boolean isDigit(char character) {
        return '0' <= character && character <= '9';
    }

    private boolean tenOrTwenty(char prev, char current) {
        return current == '0' && (prev == '1' || prev == '2');
    }

    private boolean combinable(char prev, char current) {
        return prev == '1' || (prev == '2' && current <= '6');
    }

}
