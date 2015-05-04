public class PathSum implements Runnable {

    @Override
    public void run() {
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        boolean result;
        if (root == null) {
            result = false;
        } else if (root.left == null && root.right == null) {
            result = root.val == sum;
        } else {
            result = hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
        return result;
    }

}
