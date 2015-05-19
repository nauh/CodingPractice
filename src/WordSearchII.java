import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSearchII implements Runnable {

    @Override
    public void run() {
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (words == null || words.length == 0 || board == null || board.length == 0) {
            return new ArrayList<String>();
        }

        // Build trie
        TrieNode root = new TrieNode('/');
        for (String word : words) {
            insert(root, word);
        }

        // DFS find word
        Set<String> result = new HashSet<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                findWords(board, root, result, new StringBuilder(), new HashSet<Integer>(), row, col);
            }
        }
        return new ArrayList<String>(result);
    }

    private void findWords(char[][] board, TrieNode root, Set<String> result, StringBuilder current,
        Set<Integer> checked, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        } else if (checked.contains(index(row, col, board[0].length)) || !root.map.containsKey(board[row][col])) {
            return;
        } else {
            char character = board[row][col];
            int index = index(row, col, board[0].length);
            current.append(character);
            checked.add(index);
            root = root.map.get(character);
            if (root.word) {
                result.add(current.toString());
            }
            findWords(board, root, result, current, checked, row - 1, col);
            findWords(board, root, result, current, checked, row + 1, col);
            findWords(board, root, result, current, checked, row, col - 1);
            findWords(board, root, result, current, checked, row, col + 1);
            current.deleteCharAt(current.length() - 1);
            checked.remove(index);
        }
    }

    private void insert(TrieNode root, String word) {
        TrieNode current = root;
        if (!word.isEmpty()) {
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (current.map.containsKey(currentChar)) {
                    current = current.map.get(currentChar);
                } else {
                    TrieNode newNode = new TrieNode(currentChar);
                    current.map.put(currentChar, newNode);
                    current = newNode;
                }
            }
            current.word = true;
        }
    }

    private int index(int row, int col, int width) {
        return row * width + col;
    }

    private class TrieNode {

        char character;
        boolean word;
        Map<Character, TrieNode> map;

        public TrieNode(char character) {
            this.character = character;
            this.word = false;
            this.map = new HashMap<>();
        }

    }

}
