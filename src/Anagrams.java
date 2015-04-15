import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams implements Runnable {

    @Override
    public void run() {
    }

    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<>();
        Map<String, List<String>> partition = new HashMap<>();
        for (String string : strs) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            List<String> stringList = partition.containsKey(sorted) ?
                partition.get(sorted) : new ArrayList<String>();
            stringList.add(string);
            partition.put(sorted, stringList);
        }
        for (List<String> stringList : partition.values()) {
            if (stringList.size() > 1) {
                result.addAll(stringList);
            }
        }
        return result;
    }

}
