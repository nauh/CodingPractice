import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WordLadderII implements Runnable {

    @Override
    public void run() {
        Set<String> dict = new HashSet<>();
        dict.add("a");
        dict.add("b");
        dict.add("c");
        System.out.println(findLadders("a", "c", dict));
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<>();
        if (start == end) {
            result.add(Arrays.asList(start, end));
            return result;
        }
        List<Set<String>> paths = buildPaths(start, end, dict);
        if (!paths.isEmpty()) {
            List<String> current = new ArrayList<>();
            current.add(end);
            findLadders(result, paths, current);
        }
        return result;
    }

    public List<Set<String>> buildPaths(String start, String end, Set<String> dict) {
        List<Set<String>> result = new ArrayList<>();
        Set<String> candidates = new HashSet<>();
        candidates.add(start);
        boolean shortestPathFound = false;
        while(!shortestPathFound && !candidates.isEmpty()) {
            result.add(candidates);
            Set<String> nextCandidates = new HashSet<>();
            for (String candidate : candidates) {
                int distance = distance(candidate, end);
                if (distance == 1) {
                    shortestPathFound = true;
                } else {
                    char[] charArray = candidate.toCharArray();
                    for (int i = 0; i < charArray.length; i++) {
                        char original = charArray[i];
                        for (char replace = 'a'; replace <= 'z'; replace++) {
                            charArray[i] = replace;
                            String word = new String(charArray);
                            boolean foundAlready = false;
                            for (Set<String> foundWords : result) {
                                if (foundWords.contains(word)) {
                                    foundAlready = true;
                                    break;
                                }
                            }
                            if (!foundAlready && dict.contains(word)) {
                                    nextCandidates.add(word);
                            }
                        }
                        charArray[i] = original;
                    }
                }
            }
            candidates = nextCandidates;
        }
        if (!shortestPathFound) {
            result.clear();
        }
        return result;
    }

    private void findLadders(List<List<String>> result, List<Set<String>> paths, List<String> current) {
        if (current.size() == paths.size() + 1) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (String word : paths.get(paths.size() - current.size())) {
            if (distance(current.get(0), word) == 1) {
                current.add(0, word);
                findLadders(result, paths, current);
                current.remove(0);
            }
        }
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
