public class FlattenBinaryTreeToLinkedList implements Runnable {

    @Override
    public void run() {
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        if (root.left != null) {
            flatten(root.left);
            TreeNode current = root.left;
            while (current.right != null) {
                current = current.right;
            }
            current.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }

}
