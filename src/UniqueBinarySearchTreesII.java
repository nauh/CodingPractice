import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII implements Runnable {

    @Override
    public void run() {
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
        } else if (start == end) {
            result.add(new TreeNode(start));
        } else {
            for (int i = start; i <= end; i++) {
                for (TreeNode left : generateTrees(start, i - 1)) {
                    for (TreeNode right : generateTrees(i + 1, end)) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        result.add(root);
                    }
                }
            }
        }
        return result;
    }

}
