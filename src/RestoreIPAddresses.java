import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class RestoreIPAddresses implements Runnable {

    @Override
    public void run() {
        System.out.println(restoreIpAddresses("0000"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        for (int start = 1; start <= 3; start++) {
            if (!valid(s, 0, start)) {
                continue;
            }
            for (int end = s.length() - 3; end < s.length(); end++) {
                if (!valid(s, end, s.length())) {
                    continue;
                }
                if (2 <= end - start && end - start <= 6) {
                    for (int middle = start + 1; middle < end; middle++) {
                        if (valid(s, start, middle) && valid(s, middle, end)) {
                            result.add(new StringJoiner(".").add(s.substring(0, start)).add(s.substring(start, middle)).add(s.substring(middle, end)).add(s.substring(end)).toString());
                        }
                    }
                }
            }
        }
        return result;

    }

    private boolean valid(String s, int start, int end) {
        int length = end - start;
        if (length <= 0 || length > 3) {
            return false;
        } else if (length > 1 && s.charAt(start) == '0') {
            return false;
        } else {
            int number = Integer.parseInt(s.substring(start, end));
            return 0 <= number && number < 256;
        }
    }

}
