public class SymmetricTree implements Runnable {

    @Override
    public void run() {
    }

    public boolean isSymmetric(TreeNode root) {
        return compare(root, root);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == null && right == null;
        }
        return left.val == right.val && compare(left.left, right.right) && compare(left.right, right.left);
    }

}
