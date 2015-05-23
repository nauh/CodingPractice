import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromicTreeNode {

    int start;
    int length;
    PalindromicTreeNode suffixLink;
    Map<Character, PalindromicTreeNode> edges;

    PalindromicTreeNode(int start, int length) {
        this.start = start;
        this.length = length;
        this.suffixLink = null;
        this.edges = new HashMap<>();
    }

    public static List<PalindromicTreeNode> buildPalindromicTree(String s) {
        List<PalindromicTreeNode> palindromes = new ArrayList<>();

        // create two roots
        PalindromicTreeNode minusOneRoot = new PalindromicTreeNode(0, -1);
        PalindromicTreeNode zeroRoot = new PalindromicTreeNode(0, 0);
        minusOneRoot.suffixLink = minusOneRoot;
        zeroRoot.suffixLink = minusOneRoot;

        PalindromicTreeNode maxSuffixPalindrome = minusOneRoot;
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            PalindromicTreeNode current = maxSuffixPalindrome;
            for (;;) {
                int parityIndex = i - current.length - 1; // cannot use current.start - 1 for two roots
                if (parityIndex >= 0 && s.charAt(parityIndex) == character) {
                    break;
                }
                current = current.suffixLink;
            }

            // palindrome has already been found before
            if (current.edges.containsKey(character)) {
                maxSuffixPalindrome = current.suffixLink;
                continue;
            }

            PalindromicTreeNode palindrome = new PalindromicTreeNode(i - current.length - 1, current.length + 2);
            current.edges.put(character, palindrome);
            palindromes.add(palindrome);
            maxSuffixPalindrome = palindrome;

            // find suffixLink for new palindrome
            if (palindrome.length == 1) {
                palindrome.suffixLink = zeroRoot;
            } else {
                for (;;) {
                    current = current.suffixLink;
                    int parityIndex = i - current.length - 1; // cannot use current.start - 1 for two roots
                    if (parityIndex >= 0 && s.charAt(parityIndex) == character) {
                        palindrome.suffixLink = current.edges.get(character);
                        break;
                    }
                }
            }
        }

        return palindromes;
    }

}
