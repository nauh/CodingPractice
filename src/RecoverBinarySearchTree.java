import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree implements Runnable {

    @Override
    public void run() {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(1);
        recoverTree(root);
        System.out.println(root.val + " " + root.right.val + " " + root.right.right.val);
    }

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> outOfOrder = new ArrayList<>(4);
        TreeNode current = root;
        TreeNode previous = null;
        while (current != null) {
            if (current.left != null) {
                TreeNode rightEnd = current.left;
                while (rightEnd.right != null && rightEnd.right != current) {
                    rightEnd = rightEnd.right;
                }
                if (rightEnd.right == current) {
                    rightEnd.right = null;
                    if (previous != null && previous.val > current.val) {
                        TreeNode tempPrev = previous;
                        TreeNode tempCur = current;
                        outOfOrder.add(tempPrev);
                        outOfOrder.add(tempCur);
                    }
                    previous = current;
                    current = current.right;
                } else {
                    rightEnd.right = current;
                    current = current.left;
                }
            } else {
                if (previous != null && previous.val > current.val) {
                    TreeNode tempPrev = previous;
                    TreeNode tempCur = current;
                    outOfOrder.add(tempPrev);
                    outOfOrder.add(tempCur);
                }
                previous = current;
                current = current.right;
            }
        }
        if (!outOfOrder.isEmpty()) {
            int temp = outOfOrder.get(0).val;
            outOfOrder.get(0).val = outOfOrder.get(outOfOrder.size() - 1).val;
            outOfOrder.get(outOfOrder.size() - 1).val = temp;
        }
    }

}
