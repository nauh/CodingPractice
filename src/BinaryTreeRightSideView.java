import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView implements Runnable {

    @Override
    public void run() {
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            result.add(nodes.get(0).val);
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.remove(0);
                if (node.right != null) {
                    nodes.add(node.right);
                }
                if (node.left != null) {
                    nodes.add(node.left);
                }
            }
        }
        return result;
    }

}
