public class RemoveDuplicatesFromSortedListII implements Runnable {

    @Override
    public void run() {
        System.out.println(deleteDuplicates(ListNode.createFrom(1,1)));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode previous = dummyHead;
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val != current.val) {
                previous = current;
                current = current.next;
            } else {
                while (current.next != null && current.next.val == current.val) {
                    current.next = current.next.next;
                }
                previous.next = current.next;
                current = current.next;
            }
        }
        return dummyHead.next;
    }

}
