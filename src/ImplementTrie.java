import java.util.HashMap;
import java.util.Map;

class TrieNode {

    char character;
    boolean end;
    Map<Character, TrieNode> nodes;

    // Initialize your data structure here.
    public TrieNode() {
        this.character = ' ';
        this.end = false;
        this.nodes = new HashMap<>();
    }

    public boolean contains(char character) {
        return nodes.containsKey(character);
    }

    public TrieNode get(char character) {
        return nodes.get(character);
    }

    public void put(TrieNode node) {
        nodes.put(node.character, node);
    }

    public boolean empty() {
        return nodes.isEmpty();
    }
}

public class ImplementTrie {

    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current.contains(word.charAt(i))) {
                current = current.get(word.charAt(i));
            } else {
                TrieNode newNode = new TrieNode();
                newNode.character = word.charAt(i);
                current.put(newNode);
                current = newNode;
            }
        }
        current.end = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (!current.contains(word.charAt(i))) {
                return false;
            } else {
                current = current.get(word.charAt(i));
            }
        }
        return current.end;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!current.contains(prefix.charAt(i))) {
                return false;
            } else {
                current = current.get(prefix.charAt(i));
            }
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
