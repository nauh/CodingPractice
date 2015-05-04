public class BalancedBinaryTree implements Runnable {

    @Override
    public void run() {

    }

    public boolean isBalanced(TreeNode root) {
        return depth(root) >= 0;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (left < 0 || right < 0 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }

}
