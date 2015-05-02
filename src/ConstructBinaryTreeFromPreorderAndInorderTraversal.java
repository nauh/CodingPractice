public class ConstructBinaryTreeFromPreorderAndInorderTraversal implements Runnable {

    @Override
    public void run() {
        int[] preorder = new int[] {1, 2, 3};
        int[] inorder = new int[] {2, 3, 1};
        buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart >= preorder.length || inStart >= inorder.length || preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int length = 0;
        while (inorder[inStart + length] != root.val) {
            length++;
        }
        root.left = buildTree(preorder, preStart + 1, preStart + length, inorder, inStart, inStart + length - 1);
        root.right = buildTree(preorder, preStart + length + 1, preEnd, inorder, inStart + length + 1, inEnd);
        return root;
    }

}
