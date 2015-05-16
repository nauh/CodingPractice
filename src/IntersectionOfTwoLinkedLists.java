public class IntersectionOfTwoLinkedLists implements Runnable {

    @Override
    public void run() {
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lengthA = length(headA);
        int lengthB = length(headB);
        if (lengthA > lengthB) {
            for (int i = 0; i < Math.abs(lengthA - lengthB); i++) {
                headA = headA.next;
            }
        } else if (lengthA < lengthB) {
            for (int i = 0; i < Math.abs(lengthA - lengthB); i++) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;                     
    }

    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

}
