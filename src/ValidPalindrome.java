public class ValidPalindrome implements Runnable {

    @Override
    public void run() {
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            char left = s.charAt(start);
            char right = s.charAt(end);
            if (!isAlphanumericCharacter(left)) {
                start++;
            } else if (!isAlphanumericCharacter(right)) {
                end--;
            } else {
                if (equalsIgnoreCase(left, right)) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isAlphanumericCharacter(char character) {
        return ('0' <= character && character <= '9')
            || ('a' <= character && character <= 'z')
            || ('A' <= character && character <= 'Z');
    }

    private boolean equalsIgnoreCase(char left, char right) {
        boolean result;
        if (left == right) {
            result = true;
        } else if ('a' <= left && left <= 'z') {
            result = left - right == 'a' - 'A';
        } else if ('A' <= left && left <= 'Z') {
            result = left - right == 'A' - 'a';
        } else {
            result = false;
        }
        return result;
    }

}
