import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal implements Runnable {

    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode rightMost = current.left;
                while (rightMost.right != null && rightMost.right != current) {
                    rightMost = rightMost.right;
                }
                if (rightMost.right == current) {
                    rightMost.right = null;
                    result.add(current.val);
                    current = current.right;
                } else {
                    rightMost.right = current;
                    current = current.left;
                }
            } else {
                result.add(current.val);
                current = current.right;
            }
        }
        return result;
    }

}
