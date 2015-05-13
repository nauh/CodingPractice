public class LinkedListCycleII implements Runnable {

    @Override
    public void run() {
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        int cycleLength = 0;
        ListNode slow = head, quick = head.next;
        while (slow != null && quick != null) {
            cycleLength++;
            if (slow == quick) {
                break;
            }
            slow = slow.next;
            quick = quick.next == null ? null : quick.next.next;
        }
        if (slow == null || quick == null) {
            return null;
        } else {
            slow = head;
            quick = head;
            for (int i = 0; i < cycleLength; i++) {
                quick = quick.next;
            }
            while (slow != quick) {
                slow = slow.next;
                quick = quick.next;
            }
            return slow;
        }
    }

}
