import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree implements Runnable {

    @Override
    public void run() {
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, new ArrayList<>(2));
    }

    private boolean isValidBST(TreeNode root, List<Integer> extremums) {
        if (root == null) {
            extremums.clear();
            return true;
        }
        boolean result = isValidBST(root.left, extremums);
        int min = root.val, max = root.val;
        if (!extremums.isEmpty()) {
            min = extremums.get(0);
            result &= extremums.get(1) < root.val;
        }
        result &= isValidBST(root.right, extremums);
        if (!extremums.isEmpty()) {
            max = extremums.get(1);
            result &= extremums.get(0) > root.val;
        }
        extremums.clear();
        extremums.add(min);
        extremums.add(max);
        return result;
    }

}
