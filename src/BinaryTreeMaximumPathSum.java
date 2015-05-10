public class BinaryTreeMaximumPathSum implements Runnable {

    @Override
    public void run() {

    }

    public int maxPathSum(TreeNode root) {
        TreeNode maxChildPathRoot = new TreeNode(0);
        constructMaxChildPathSumTree(root, maxChildPathRoot);
        return getMaxPathSum(root, maxChildPathRoot);
    }

    private void constructMaxChildPathSumTree(TreeNode root, TreeNode maxChildPathRoot) {
        maxChildPathRoot.left = new TreeNode(0);
        maxChildPathRoot.right = new TreeNode(0);
        if (root != null) {
            constructMaxChildPathSumTree(root.left, maxChildPathRoot.left);
            constructMaxChildPathSumTree(root.right, maxChildPathRoot.right);
            maxChildPathRoot.val = root.val + Math.max(Math.max(0, maxChildPathRoot.left.val),
                Math.max(0, maxChildPathRoot.right.val));
        }
    }

    private int getMaxPathSum(TreeNode root, TreeNode maxChildPathRoot) {
        if (root == null) {
            return 0;
        }
        int max = root.val + Math.max(0, maxChildPathRoot.left.val) + Math.max(0, maxChildPathRoot.right.val);
        if (root.left != null) {
            max = Math.max(max, getMaxPathSum(root.left, maxChildPathRoot.left));
        }
        if (root.right != null) {
            max = Math.max(max, getMaxPathSum(root.right, maxChildPathRoot.right));
        }
        return max;
    }

}
