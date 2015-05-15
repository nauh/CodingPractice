public class ReverseWordsInAString implements Runnable {

    @Override
    public void run() {
        System.out.println(reverseWords("   a   b "));
    }

    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        s = s.trim();
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (result.length() > 0 && s.charAt(i) == ' ' && result.charAt(result.length() - 1) == ' ') {
                continue;
            }
            result.append(s.charAt(i));
        }

        int start = 0, end = -1;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == ' ') {
                if (end >= 0) {
                    reverse(result, start, end);
                    start = i + 1;
                    end = -1;
                }
            } else {
                end = i;
                if (i == result.length() - 1) {
                    reverse(result, start, end);
                }
            }
        }
        return result.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, temp);
        }
    }

}
