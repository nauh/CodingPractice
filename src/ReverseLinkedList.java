public class ReverseLinkedList implements Runnable {

    @Override
    public void run() {
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode currentCopy = current;
            current = current.next;
            currentCopy.next = prev;
            prev = currentCopy;
        }
        return prev;
    }

}
