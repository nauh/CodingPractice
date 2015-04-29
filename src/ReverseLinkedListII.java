public class ReverseLinkedListII implements Runnable {

    @Override
    public void run() {
        System.out.println(reverseBetween(ListNode.createFrom(1,2,3), 1, 3));
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }

        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        ListNode start = dummyHead;
        ListNode current = head;
        int index = 1;
        while (index < m) {
            start = start.next;
            current = current.next;
            index += 1;
        }

        while (m <= index && index < n) {
            ListNode temp = current.next;
            current.next = current.next.next;
            temp.next = start.next;
            start.next = temp;
            index += 1;
        }
        return dummyHead.next;
    }

}
