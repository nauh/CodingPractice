public class CopyListWithRandomPointer implements Runnable {

    @Override
    public void run() {
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode current = head;
        while (current != null) {
            RandomListNode copy = new RandomListNode(current.label);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        current = head;
        while (current != null) {
            current.next.random = current.random == null ? null : current.random.next;
            current = current.next.next;
        }

        current = head;
        RandomListNode result = head.next;
        while (current != null) {
            RandomListNode copy = current.next;
            current.next = copy.next;
            copy.next = current.next == null ? null : current.next.next;
            current = current.next;
        }

        return result;
    }

    private class RandomListNode {

        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

}
