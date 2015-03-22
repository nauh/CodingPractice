import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofAPhoneNumber implements Runnable {

    @Override
    public void run() {
        for (String result : letterCombinations("2")) {
            System.out.println(result);
        }
    }

    public List<String> letterCombinations(String digits) {
        String[] characters = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return letterCombinations(digits, characters);
    }

    List<String> letterCombinations(String digits, String[] characters) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> combinations = letterCombinations(digits.substring(1), characters);
        if (digits.charAt(0) < '2' || digits.charAt(0) > '9') {
            return combinations;
        }

        if (combinations.isEmpty()) {
            combinations.add("");
        }

        List<String> result = new ArrayList<>();
        String letters = characters[Character.getNumericValue(digits.charAt(0))];
        for (int i = 0; i < letters.length(); i++) {
            char characterToAdd = letters.charAt(i);
            for (String combination : combinations) {
                result.add(characterToAdd + combination);
            }
        }
        return result;
    }

}
