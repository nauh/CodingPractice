import java.util.HashMap;
import java.util.Map;

public class RomanToInteger implements Runnable {

    @Override
    public void run() {
        System.out.println(romanToInt("MMXVI"));
    }

    public int romanToInt(String string) {
        Map<Character, Integer> numeralValue = new HashMap<>();
        numeralValue.put('I', 1);
        numeralValue.put('V', 5);
        numeralValue.put('X', 10);
        numeralValue.put('L', 50);
        numeralValue.put('C', 100);
        numeralValue.put('D', 500);
        numeralValue.put('M', 1_000);
        
        int result = 0;
        int index = 0;
        while (index < string.length()) {
            if (index + 1 < string.length() && numeralValue.get(string.charAt(index + 1))
                > numeralValue.get(string.charAt(index))) {
                result += numeralValue.get(string.charAt(index + 1)) - numeralValue.get(string.charAt(index));
                index += 2;
            } else {
                result += numeralValue.get(string.charAt(index));
                index += 1;
            }
        }
        return result;
    }

}
