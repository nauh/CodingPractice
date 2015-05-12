public class LinkedListCycle implements Runnable {

    @Override
    public void run() {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        while (slow != null && quick != null) {
            if (slow == quick) {
                return true;
            }
            slow = slow.next;
            quick = quick.next == null ? null : quick.next.next;
        }
        return false;
    }

}
