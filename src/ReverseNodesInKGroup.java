import java.util.StringJoiner;

public class ReverseNodesInKGroup implements Runnable {

    @Override
    public void run() {
        ListNode head = createList(1, 2, 3, 4, 5, 6, 7, 8);
        print(reverseKGroup(head, 3));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int reverse = k;
        ListNode previous = null;
        ListNode current = head;
        while (current != null && reverse > 0) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            reverse--;
        }

        ListNode result;
        if (reverse > 0) {
            result = reverseKGroup(previous, k - reverse);
        } else {
            head.next = reverseKGroup(current, k);
            result = previous;
        }
        return result;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private ListNode createList(int... integers) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode currentHead = dummyHead;
        for(int i : integers) {
            currentHead.next = new ListNode(i);
            currentHead = currentHead.next;
        }
        return dummyHead.next;
    }

    private void print(ListNode head) {
        StringJoiner stringJoiner = new StringJoiner(" -> ");
        while (head != null) {
            stringJoiner.add(Integer.toString(head.val));
            head = head.next;
        }
        System.out.println(stringJoiner.toString());
    }

}
