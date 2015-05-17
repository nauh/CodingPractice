import java.util.Stack;

public class BinarySearchTreeIterator {

    private final Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        this.stack = new Stack<>();
        push(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            push(node.right);
        }
        return node.val;
    }

    private void push(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

}
