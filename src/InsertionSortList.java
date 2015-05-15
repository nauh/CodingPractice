public class InsertionSortList implements Runnable {

    @Override
    public void run() {
        System.out.println(insertionSortList(ListNode.createFrom(1, 1)));
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }

        ListNode sortedDummyHead = new ListNode(0);
        ListNode unsortedHead = head;
        while (unsortedHead != null) {
            ListNode node = unsortedHead;
            unsortedHead = unsortedHead.next;
            insert(sortedDummyHead, node);
        }
        return sortedDummyHead.next;
    }

    private void insert(ListNode sortedDummyHead, ListNode node) {
        ListNode currentHead = sortedDummyHead;
        while (currentHead.next != null) {
            if (node.val <= currentHead.next.val) {
                node.next = currentHead.next;
                currentHead.next = node;
                return;
            }
            currentHead = currentHead.next;
        }
        currentHead.next = node;
        node.next = null;
    }

}
