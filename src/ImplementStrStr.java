public class ImplementStrStr implements Runnable {

    @Override
    public void run() {
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        int result = -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (match(needle, haystack, i)) {
                result = i;
                break;
            }
        }
        return result;
    }

    private boolean match(String needle, String haystack, int startIndex) {
        for (int i = 0; i < needle.length(); i++) {
            if (haystack.charAt(startIndex + i) != needle.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}
