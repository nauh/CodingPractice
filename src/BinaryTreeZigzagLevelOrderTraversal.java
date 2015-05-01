import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal implements Runnable {

    @Override
    public void run() {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        boolean leftToRight = true;
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        while (treeNodes.size() > 0) {
            int currentSize = treeNodes.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = treeNodes.remove(0);
                int insert = leftToRight ? list.size() : 0;
                list.add(insert, node.val);
                if (node.left != null) {
                    treeNodes.add(node.left);
                }
                if (node.right != null) {
                    treeNodes.add(node.right);
                }
            }
            result.add(list);
            leftToRight = !leftToRight;
        }
        return result;
    }

}
