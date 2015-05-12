import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII implements Runnable {

    @Override
    public void run() {
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.isEmpty() || !wordBreakExist(s, wordDict)) {
            return new ArrayList<>();
        }
        Map<Integer, List<String>> result = new HashMap<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            List<String> current = new ArrayList<>();
            for (int j = i; j < s.length(); j++) {
                if (wordDict.contains(s.substring(i, j + 1))) {
                    String toAdd = s.substring(i, j + 1);
                    if (j == s.length() - 1) {
                        current.add(toAdd);
                    } else {
                        for (String string : result.get(j + 1)) {
                            current.add(toAdd + " " + string);
                        }
                    }
                }
            }
            result.put(i, current);
        }
        return result.get(0);
    }

    private boolean wordBreakExist(String s, Set<String> wordDict) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        boolean[] trace = new boolean[s.length()];
        boolean last = true;
        for (int i = 0; i < trace.length; i++) {
            if (last) {
                for (int j = i; j < trace.length; j++) {
                    trace[j] |= wordDict.contains(s.substring(i, j + 1));
                }
            }
            last = trace[i];
        }
        return trace[trace.length - 1];
    }

}
