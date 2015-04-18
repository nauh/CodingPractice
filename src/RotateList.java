public class RotateList implements Runnable {

    @Override
    public void run() {
        ListNode node = ListNode.createFrom(1,2,3);
        System.out.println(rotateRight(node, 2000000000));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        if (k % length != 0) {
            ListNode current = head;
            for (int i = 1; i < length - k % length; i++) {
                current = current.next;
            }
            tail.next = head;
            head = current.next;
            current.next = null;
        }
        return head;
    }

}
