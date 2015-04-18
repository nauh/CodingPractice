import java.util.StringJoiner;

public class ListNode {

    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    public String toString() {
        StringJoiner sj = new StringJoiner(",", "{", "}");
        sj.add(String.valueOf(val));
        ListNode current = next;
        while (current != null) {
            sj.add(String.valueOf(current.val));
            current = current.next;
        }
        return sj.toString();
    }

    public static ListNode createFrom(int... values) {
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummyHead.next;
    }

}
