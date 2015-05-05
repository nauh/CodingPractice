public class PopulatingNextRightPointersInEachNode implements Runnable {

    @Override
    public void run() {
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
            connect(root.left);
            connect(root.right);
        }
    }

}
