import java.util.Set;

public class WordBreak implements Runnable {

    @Override
    public void run() {
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
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
