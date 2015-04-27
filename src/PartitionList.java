public class PartitionList implements Runnable {

    @Override
    public void run() {
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        ListNode insert = dummyHead;
        ListNode previous = dummyHead;
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                if (insert.next == current) {
                    insert = current;
                    previous = current;
                    current = current.next;
                } else {
                    previous.next = current.next;
                    current.next = insert.next;
                    insert.next = current;
                    insert = current;
                    current = previous.next;
                }
            } else {
                previous = current;
                current = current.next;
            }
        }
        return dummyHead.next;
    }

}
