import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords implements Runnable {

    @Override
    public void run() {
        System.out.println(findSubstring("aaa", new String[] {"a"}));
    }

    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<>();

        if (L.length == 0 || S.length() < L[0].length()) {
            return result;
        }

        int wordLength = L[0].length();
        for (int i = 0; i < wordLength; i++) {
            int index = i;
            int start = index;
            int end = start + wordLength;
            int wordCount = 0;
            Map<String, Integer> words = toMap(L);
            while (index <= S.length() - L.length * wordLength && end <= S.length()) {
                String word = S.substring(start, end);
                if (words.containsKey(word)) {
                    words.put(word, words.get(word) - 1);
                    wordCount++;
                    if (wordCount == L.length) {
                        if (isResult(words)) {
                            result.add(index);
                        }
                        word = S.substring(index, index + wordLength);
                        words.put(word, words.get(word) + 1);
                        index += wordLength;
                        wordCount--;
                    }
                } else {
                    index = end;
                    words = toMap(L);
                    wordCount = 0;
                }
                start = end;
                end += wordLength;
            }
        }
        return result;
    }

    private Map<String, Integer> toMap(String[] L) {
        Map<String, Integer> result = new HashMap<>();
        for (String string : L) {
            int count = result.containsKey(string) ? result.get(string) + 1 : 1;
            result.put(string, count);
        }
        return result;
    }

    private boolean isResult(Map<String, Integer> words) {
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

}
