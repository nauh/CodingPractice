import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal implements Runnable {

    @Override
    public void run() {
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode top = stack.peek();
            result.add(top.val);
            if (top.left != null) {
                stack.push(top.left);
            } else {
                TreeNode poped = stack.pop();
                while (poped.right == null && !stack.empty()) {
                    poped = stack.pop();
                }
                if (poped.right != null) {
                    stack.push(poped.right);
                }
            }
        }
        return result;
    }

}
