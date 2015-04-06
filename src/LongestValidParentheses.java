import java.util.Stack;

public class LongestValidParentheses implements Runnable {

    @Override
    public void run() {
        System.out.println(getLongestLenByStack("((()"));
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int longest = 0;
        int[] length = new int[s.length()];
        length[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                length[i] = 0;
            } else {
                if (s.charAt(i - 1) == '(') {
                    length[i] = 2 + (i - 2 >= 0 ? length[i - 2] : 0);
                } else {
                    int prev = i - 1 - length[i - 1];
                    if (prev < 0 || s.charAt(prev) == ')') {
                        length[i] = 0;
                    } else {
                        length[i] = 2 + length[i - 1] + (prev - 1 >= 0 ? length[prev - 1] : 0);
                    }
                }
            }
            longest = Math.max(longest, length[i]);
        }
        return longest;
    }

    public int slowLongestValidParentheses(String s) {
        int length = s.length();
        if (length < 2) {
            return 0;
        }

        int[][] score = new int[length][length];
        for (int i = 0; i < length; i++) {
            score[i][i] = s.charAt(i) == '(' ? 1 : -1;
        }

        for (int row = length - 2; row >= 0 ; row--) {
            for (int col = row + 1; col < length; col++) {
                int rest = score[row + 1][col];
                score[row][col] = s.charAt(row) == '(' ? rest + 1 : rest - 1;
            }
        }

        int longest = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (score[i][j] < 0) {
                    break;
                } else if (score[i][j] == 0) {
                    longest = Math.max(longest, j - i + 1);
                } else {
                    continue;
                }
            }
        }
        return longest;
    }

    private int getLongestLenByStack(String s) {
        //use last to store the last matched index
        int len = s.length(), maxLen = 0, last = -1;
        if (len == 0 || len == 1)
            return 0;

        //use this stack to store the index of '('
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                //if stack is empty, it means that we already found a complete valid combo
                //update the last index.
                if (stack.isEmpty()) {
                    last = i;
                } else {
                    stack.pop();
                    //found a complete valid combo and calculate max length
                    if (stack.isEmpty())
                        maxLen = Math.max(maxLen, i - last);
                    else
                    //calculate current max length
                        maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}
