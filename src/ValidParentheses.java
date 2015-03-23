import java.util.Stack;

public class ValidParentheses implements Runnable {

    @Override
    public void run() {

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (!stack.empty() && isPair(stack.peek(), character)) {
                stack.pop();
            } else {
                stack.push(character);
            }
        }
        return stack.empty();
    }

    boolean isPair(char left, char right) {
        return (left == '(' && right == ')') || (left == '{' && right == '}')
            || (left == '[' && right == ']');
    }

}
