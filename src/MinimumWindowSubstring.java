import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring implements Runnable {

    @Override
    public void run() {
        System.out.println(minWindow("aaabdabcefaecbef", "abc"));
    }

    public String minWindow(String s, String t) {
        if (t == null || t.isEmpty() || s == null || s.isEmpty()) {
            return "";
        }

        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char character = t.charAt(i);
            int count = charMap.containsKey(character) ? charMap.get(character) : 0;
            charMap.put(character, count + 1);
        }

        int count = 0, start = 0;
        int minStart = 0, minimumLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (!charMap.containsKey(character)) {
                continue;
            }
            charMap.put(character, charMap.get(character) - 1);
            if (charMap.get(character) >= 0) {
                count++;
            }
            while (count == t.length()) {
                int length = i - start + 1;
                if (minimumLength == 0 || length < minimumLength) {
                    minStart = start;
                    minimumLength = length;
                }
                if (charMap.containsKey(s.charAt(start))) {
                    charMap.put(s.charAt(start), charMap.get(s.charAt(start)) + 1);
                    if (charMap.get(s.charAt(start)) > 0) {
                        count--;
                    }
                }
                start++;
            }
        }
        return s.substring(minStart, minStart + minimumLength);
    }

}
