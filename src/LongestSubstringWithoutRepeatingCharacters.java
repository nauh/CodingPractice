import java.util.Map;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters implements Runnable {

    @Override
    public void run() {
        String input = "bpfbhmipx";
        System.out.println(lengthOfLongestSubstring(input));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int startIndex = 0;
        int maximumLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (charMap.containsKey(character)) {
                int lastIndex = charMap.get(character);
                if (lastIndex >= startIndex) {
                    startIndex = lastIndex + 1;
                }
            }
            charMap.put(character, i);
            maximumLength = Math.max(i - startIndex + 1, maximumLength);
        }
        return maximumLength;
    }

}
