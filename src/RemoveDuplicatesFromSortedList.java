public class RemoveDuplicatesFromSortedList implements Runnable {

    @Override
    public void run() {
        System.out.println(deleteDuplicates(ListNode.createFrom(1, 1)));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode previous = current;
        while (current != null) {
            if (current.val == previous.val) {
                previous.next = current.next;
                current = previous.next;
            } else {
                previous = current;
                current = current.next;
            }
        }
        return head;
    }

}
