public class MinimumDepthOfBinaryTree implements Runnable {

    @Override
    public void run() {
    }

    public int minDepth(TreeNode root) {
        int result;
        if (root == null) {
            result = 0;
        } else if (root.left == null) {
            result = 1 + minDepth(root.right);
        } else if (root.right == null) {
            result = 1 + minDepth(root.left);
        } else {
            result = 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
        return result;
    }

}
