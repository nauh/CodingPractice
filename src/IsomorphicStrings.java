import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings implements Runnable {

    @Override
    public void run() {
    }

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        } else if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Set<Character> mapped = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (map.containsKey(sChar)) {
                if (tChar != map.get(sChar)) {
                    return false;
                }
            } else {
                if (mapped.contains(tChar)) {
                    return false;
                }
                mapped.add(tChar);
                map.put(sChar, tChar);
            }
        }
        return true;
    }

}
