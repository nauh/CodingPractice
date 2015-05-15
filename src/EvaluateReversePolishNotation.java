import java.util.Stack;

public class EvaluateReversePolishNotation implements Runnable {

    @Override
    public void run() {
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> operands = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            Integer number = toInteger(tokens[i]);
            if (number != null) {
                operands.push(number);
            } else {
                int rightOperand = operands.pop();
                int leftOperand = operands.pop();
                switch (tokens[i]) {
                    case "+" :
                        operands.push(leftOperand + rightOperand);
                        break;
                    case "-" :
                        operands.push(leftOperand - rightOperand);
                        break;
                    case "*" :
                        operands.push(leftOperand * rightOperand);
                        break;
                    case "/" :
                        operands.push(leftOperand / rightOperand);
                        break;
                    default :
                        break;
                }
            }
        }
        return operands.pop();
    }

    private Integer toInteger(String string) {
        Integer result = null;
        try {
            result = Integer.parseInt(string);
        } catch (Exception e) {
        }
        return result;
    }

}
