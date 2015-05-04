public class ConstructBinaryTreeFromInorderAndPostorderTraversal implements Runnable {

    @Override
    public void run() {
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart >= inorder.length || postStart >= postorder.length || inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int length = 0;
        while (inorder[inStart + length] != root.val) {
            length++;
        }
        root.left = buildTree(inorder, inStart, inStart + length - 1, postorder, postStart, postStart + length - 1);
        root.right = buildTree(inorder, inStart + length + 1, inEnd, postorder, postStart + length, postEnd - 1);
        return root;
    }

}
