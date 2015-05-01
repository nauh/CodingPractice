public class MaximumDepthOfBinaryTree implements Runnable {

    @Override
    public void run() {

    }

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
