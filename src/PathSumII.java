import java.util.ArrayList;
import java.util.List;

public class PathSumII implements Runnable {

    @Override
    public void run() {
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        } else if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> path = new ArrayList<>();
                path.add(root.val);
                result.add(path);
            }
            return result;
        } else {
            List<List<Integer>> left = pathSum(root.left, sum - root.val);
            List<List<Integer>> right = pathSum(root.right, sum - root.val);
            if (!left.isEmpty()) {
                for (List<Integer> path : left) {
                    path.add(0, root.val);
                }
            }
            if (!right.isEmpty()) {
                for (List<Integer> path : right) {
                    path.add(0, root.val);
                }
            }
            result.addAll(left);
            result.addAll(right);
            return result;
        }
    }

}
