import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLists implements Runnable {

    @Override
    public void run() {
        try {
            ListNode listNode = mergeKLists(Arrays.asList(createListNode(-8,-7,-7,-5,1,1,3,4),
                createListNode(-2), createListNode(-10,-10,-7,0,1,3), createListNode(2)));
            while (listNode != null) {
                System.out.println(listNode.val);
                listNode = listNode.next;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode head = dummyHead;
        BinaryHeap heap = new BinaryHeap(HeapType.MIN);
        for (ListNode listNode : lists) {
            if (listNode != null) {
                heap.insert(listNode);
                listNode = listNode.next;
            }
        }

        while (!heap.isEmpty()) {
            ListNode listNode = heap.pop();
            if (listNode.next != null) {
                heap.insert(listNode.next);
            }
            head.next = listNode;
            head = head.next;
        }

        return dummyHead.next;
    }

    class BinaryHeap {

        private final List<ListNode> listNodes;
        private final HeapType heapType;

        public BinaryHeap(final HeapType heapType) {
            this.heapType = heapType;
            this.listNodes = new ArrayList<>();
        }

        public void insert(ListNode listNode) {
            listNodes.add(listNode);

            int child = listNodes.size() - 1;
            int parent = parent(child);
            while(child > 0 && compare(child, parent)) {
                swap(child, parent);
                child = parent;
                parent = parent(child);
            }
        }

        public ListNode pop() {
            swap(0, listNodes.size() - 1);
            ListNode result = listNodes.remove(listNodes.size() - 1);

            int parent = 0;
            int child = targetChild(parent);
            while (child > 0 && compare(child, parent)) {
                swap(child, parent);
                parent = child;
                child = targetChild(parent);
            }
            return result;
        }

        public boolean isEmpty() {
            return listNodes.isEmpty();
        }

        private int targetChild(int index) {
            int result;
            if (left(index) >= listNodes.size()) {
                result = -1;
            } else if (right(index) >= listNodes.size()) {
                result = left(index);
            } else {
                result = compare(left(index), right(index)) ? left(index) : right(index);
            }
            return result;
        }

        private boolean compare(int one, int other) {
            int oneNumber = listNodes.get(one).val;
            int otherNumber = listNodes.get(other).val;
            return heapType == HeapType.MAX ? oneNumber > otherNumber : oneNumber < otherNumber;
        }

        private void swap(int i, int j) {
            listNodes.set(i, listNodes.set(j, listNodes.get(i)));
            return;
        }

        private int parent(int index) {
            return (index - 1) / 2;
        }

        private int left(int index) {
            return index * 2 + 1;
        }

        private int right(int index) {
            return index * 2 + 2;
        }
    }

    enum HeapType {
        MAX, MIN
    }

    private ListNode createListNode(int... numbers) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode head = dummyHead;
        for (Integer number : numbers) {
            head.next = new ListNode(number);
            head = head.next;
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
