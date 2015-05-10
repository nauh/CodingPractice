public class SumRootToLeafNumbers implements Runnable {

    @Override
    public void run() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.right = new TreeNode(1);
        System.out.println(sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] currentAndTotal = new int[2];
        sumNumbers(root, currentAndTotal);
        return currentAndTotal[1];
    }

    private void sumNumbers(TreeNode root, int[] currentAndTotal) {
        int current = currentAndTotal[0] * 10 + root.val;
        if (root.left == null && root.right == null) {
            currentAndTotal[1] += current;
        } else {
            if (root.left != null) {
                currentAndTotal[0] = current;
                sumNumbers(root.left, currentAndTotal);
            }
            if (root.right != null) {
                currentAndTotal[0] = current;
                sumNumbers(root.right, currentAndTotal);
            }
        }
    }

}
