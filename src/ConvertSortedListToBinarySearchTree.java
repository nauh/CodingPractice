import java.util.concurrent.atomic.AtomicReference;

public class ConvertSortedListToBinarySearchTree implements Runnable {

    @Override
    public void run() {
        sortedListToBST(ListNode.createFrom(3, 5, 8));
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count += 1;
            current = current.next;
        }
        return helper(new AtomicReference<ListNode>(head), 0, count - 1);

    }

    private TreeNode helper(AtomicReference<ListNode> current, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (start + end) / 2;
        TreeNode left = helper(current, start, middle - 1);
        TreeNode root = new TreeNode(current.get().val);
        root.left = left;
        current.set(current.get().next);
        root.right = helper(current, middle + 1, end);
        return root;
    }

}
