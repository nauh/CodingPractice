public class PopulatingNextRightPointersInEachNodeII implements Runnable {

    @Override
    public void run() {
    }

    public void connect(TreeLinkNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        if (root.left != null) {
            root.left.next = root.right;
        }
        TreeLinkNode toLink = root.right == null ? root.left : root.right;
        TreeLinkNode rootNext = root.next;
        while (rootNext != null) {
            if (rootNext.left == null && rootNext.right == null) {
                rootNext = rootNext.next;
            } else {
                toLink.next = rootNext.left != null ? rootNext.left : rootNext.right;
                break;
            }
        }
        connect(root.right);
        connect(root.left);
    }

}
