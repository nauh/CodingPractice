import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences implements Runnable {

    @Override
    public void run() {
    }

    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() <= 10) {
            return new ArrayList<String>();
        }
        Set<String> seen = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String candidate = s.substring(i, i + 10);
            if (seen.contains(candidate)) {
                result.add(candidate);
            } else {
                seen.add(candidate);
            }
        }
        return new ArrayList<String>(result);
    }

}
