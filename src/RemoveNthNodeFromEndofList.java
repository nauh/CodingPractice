public class RemoveNthNodeFromEndofList implements Runnable {

    @Override
    public void run() {
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = head;
        while (start.next != null && n > 0) {
            start = start.next;
            n--;
        }

        ListNode result;
        if (n > 1) {
            result = head;
        } else if (n == 1) {
            result = head.next;
        } else {
            ListNode localHead = head;
            while (start.next != null) {
                start = start.next;
                localHead = localHead.next;
            }
            localHead.next = localHead.next.next;
            result = head;
        }
        return result;
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
