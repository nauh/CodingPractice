import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII implements Runnable {

    @Override
    public void run() {
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        while (treeNodes.size() > 0) {
            int currentSize = treeNodes.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = treeNodes.remove(0);
                list.add(node.val);
                if (node.left != null) {
                    treeNodes.add(node.left);
                }
                if (node.right != null) {
                    treeNodes.add(node.right);
                }
            }
            result.add(0, list);
        }
        return result;
    }

}
