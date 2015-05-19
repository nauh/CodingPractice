import java.util.HashMap;
import java.util.Map;

public class AddAndSearchWord implements Runnable {

    @Override
    public void run() {
        WordDictionary dict = new WordDictionary();
        dict.addWord("ab");
        System.out.println(dict.search("a."));
    }

    public class WordDictionary {

        private TrieNode root = new TrieNode();

        // Adds a word into the data structure.
        public void addWord(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                if (current.nodes.containsKey(word.charAt(i))) {
                    current = current.nodes.get(word.charAt(i));
                } else {
                    TrieNode newNode = new TrieNode();
                    newNode.character = word.charAt(i);
                    current.nodes.put(newNode.character, newNode);
                    current = newNode;
                }
            }
            current.end = true;
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            return search(word, 0, root);
        }

        private boolean search(String word, int start, TrieNode node) {
            TrieNode current = node;
            if (start >= word.length()) {
                return current.end;
            }
            for (int i = start; i < word.length(); i++) {
                if (word.charAt(i) == '.') {
                    boolean result = false;
                    for (TrieNode nextNode : current.nodes.values()) {
                        result |= search(word, i + 1, nextNode);
                    }
                    return result;
                } else {
                    if (current.nodes.containsKey(word.charAt(i))) {
                        current = current.nodes.get(word.charAt(i));
                    } else {
                        return false;
                    }
                }
            }
            return current.end;
        }

        private class TrieNode {
            char character;
            boolean end;
            Map<Character, TrieNode> nodes;

            // Initialize your data structure here.
            public TrieNode() {
                this.character = ' ';
                this.end = false;
                this.nodes = new HashMap<>();
            }
        }

    }
    
}
