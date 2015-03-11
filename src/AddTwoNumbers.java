public class AddTwoNumbers implements Runnable {

    @Override
    public void run() {
        System.out.println("Not implemented");
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode previousNode = result;
        int digit1 = 0;
        int digit2 = 0;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            if (l1 != null) {
                digit1 = l1.val;
                l1 = l1.next;
            } else {
                digit1 = 0;
            }
            if (l2 != null) {
                digit2 = l2.val;
                l2 = l2.next;
            } else {
                digit2 = 0;
            }
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            previousNode.next = new ListNode(sum % 10);
            previousNode = previousNode.next;
        }
        return result.next;
    }

    // Definition for singly-linked list.
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
