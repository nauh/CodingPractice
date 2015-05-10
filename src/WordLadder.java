import java.util.HashSet;
import java.util.Set;

public class WordLadder implements Runnable {

    @Override
    public void run() {
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if (beginWord == endWord) {
            return 1;
        }
        int result = 2;
        Set<String> checked = new HashSet<>();
        Set<String> candidates = new HashSet<>();
        candidates.add(beginWord);
        while(!candidates.isEmpty()) {
            Set<String> nextCandidates = new HashSet<>();
            for (String candidate : candidates) {
                int distance = distance(candidate, endWord);
                if (distance == 1) {
                    return result;
                } else {
                    char[] charArray = candidate.toCharArray();
                    for (int i = 0; i < charArray.length; i++) {
                        char original = charArray[i];
                        for (char replace = 'a'; replace <= 'z'; replace++) {
                            charArray[i] = replace;
                            String word = new String(charArray);
                            if (!checked.contains(word) && !candidates.contains(word)
                                && wordDict.contains(word)) {
                                    nextCandidates.add(word);
                            }
                        }
                        charArray[i] = original;
                    }
                }
            }
            checked.addAll(candidates);
            candidates = nextCandidates;
            result++;
        }
        return 0;
    }

    private int distance(String source, String target) {
        int distance = 0;
        int length = source.length();
        for (int i = 0; i < length; i++) {
            if (source.charAt(i) != target.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

}
