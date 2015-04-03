public class SwapNodesInPairs implements Runnable {

    @Override
    public void run() {
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        ListNode currentHead = dummyHead;
        while(currentHead.next != null && currentHead.next.next != null) {
            ListNode temp = currentHead.next;
            currentHead.next = currentHead.next.next;
            temp.next = currentHead.next.next;
            currentHead.next.next = temp;
            currentHead = temp;
        }
        return dummyHead.next;
    }

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
