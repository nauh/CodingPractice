public class LongestPalindromicSubstring implements Runnable {

    @Override
    public void run() {
        String input = "aaaa";
        System.out.println(longestPalindrome(input));
    }

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maximumLength = 0;
        int longestStart = -1;
        int longestEnd = -1;
        for (int i = 0; i < s.length(); i++) {
            Result one = helper(s, i - 1, i + 1);
            Result other = helper(s, i - 1, i);
            Result result = one.length >= other.length ? one : other;

            if (maximumLength < result.length) {
                maximumLength = result.length;
                longestStart = result.start;
                longestEnd = result.end;
            }
        }

        return s.substring(longestStart, longestEnd + 1);
    }

    Result helper(String s, int start, int end) {
        Result result = new Result(0, -1, -1);
        int currentLength = end - start - 1;

        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                currentLength += 2;
                if (currentLength > result.length) {
                    result.length = currentLength;
                    result.start = start;
                    result.end = end;
                }
            } else {
                break;
            }
            start--;
            end++;
        }

        return result;
    }

    class Result {
        int length;
        int start;
        int end;

        Result(int length, int start, int end) {
            this.length = length;
            this.start = start;
            this.end = end;
        }
    }

}
