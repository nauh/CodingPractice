public class SortList implements Runnable {

    @Override
    public void run() {
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode walker = dummyHead;
        ListNode runner = dummyHead;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode rightHead = walker.next;
        walker.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(rightHead);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        while (left != null || right != null) {
            if (left == null) {
                current.next = right;
                right = right.next;
            } else if (right == null) {
                current.next = left;
                left = left.next;
            } else {
                if (left.val < right.val) {
                    current.next = left;
                    left = left.next;
                } else {
                    current.next = right;
                    right = right.next;
                }
            }
            current = current.next;
        }
        return dummyHead.next;
    }

}
