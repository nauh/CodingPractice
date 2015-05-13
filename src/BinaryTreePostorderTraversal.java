import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal implements Runnable {

    @Override
    public void run() {
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode previous = null;
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode top = stack.peek();
                if (top.right == null || top.right == previous) {
                    result.add(stack.pop().val);
                    previous = top;
                } else {
                    root = top.right;
                }
            }
        }
        return result;
    }

}
