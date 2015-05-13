public class ReorderList implements Runnable {

    @Override
    public void run() {
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode walker = dummyHead, runner = dummyHead;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode right;
        if (runner.next == null) {
            right = walker.next;
            walker.next = null;
        } else {
            right = walker.next.next;
            walker.next.next = null;
        }

        ListNode previous = null;
        while (right.next != null) {
            ListNode temp = right.next;
            right.next = previous;
            previous = right;
            right = temp;
        }
        right.next = previous;

        ListNode left = head;
        while (right != null) {
            ListNode tempLeft = left.next;
            ListNode tempRight = right.next;
            left.next = right;
            right.next = tempLeft;
            left = tempLeft;
            right = tempRight;
        }
    }

}
