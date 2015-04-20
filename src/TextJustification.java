import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class TextJustification {

    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<>();
        int start = 0;
        int wordLength = 0;
        for (int i = 0; i < words.length; i++) {
            int minSpace = i - start;
            if (wordLength + words[i].length() + minSpace > L) {
                result.add(build(words, start, i - 1, L - wordLength));
                start = i;
                wordLength = words[i].length();
            } else {
                wordLength += words[i].length();
            }
        }
        StringJoiner sj = new StringJoiner(" ");
        for (int i = start; i < words.length; i++) {
            sj.add(words[i]);
        }
        StringBuilder sb = new StringBuilder(sj.toString());
        if (sb.length() < L) {
            sb.append(emptyStringOfLength(L - sb.length()));
        }
        result.add(sb.toString());
        return result;
    }

    private String build(String[] words, int start, int end, int spaceCount) {
        StringBuilder sb = new StringBuilder();
        sb.append(words[start]);
        if (start == end) {
            sb.append(emptyStringOfLength(spaceCount));
        } else {
            int wordsLeft = end - start;
            for (int i = start + 1; i <= end; i++) {
                int currentIndex = i - (start + 1);
                while (currentIndex < spaceCount) {
                    sb.append(" ");
                    currentIndex += wordsLeft;
                }
                sb.append(words[i]);
            }
        }
        return sb.toString();
    }

    private String emptyStringOfLength(int length) {
        char[] spaces = new char[length];
        Arrays.fill(spaces, ' ');
        return new String(spaces);
    }

}
