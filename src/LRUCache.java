import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int capacity;
    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> cache;

    public LRUCache(int capacity) {
        ListNode sentinel = new ListNode(-1, -1);
        this.head = sentinel;
        this.tail = sentinel;
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.capacity = capacity;
        this.cache = new HashMap<>();
    }

    public int get(int key) {
        int result = -1;
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            result = node.val;
            update(head, node);
        }
        return result;
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            node.val = value;
            update(head, node);
        } else {
            if (cache.size() == capacity) {
                cache.remove(tail.prev.key);
                remove(tail);
            }
            ListNode node = new ListNode(key, value);
            cache.put(node.key, node);
            insert(head, node);
        }
    }

    private void insert(ListNode head, ListNode node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    private void remove(ListNode tail) {
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }

    private void update(ListNode head, ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private class ListNode {

        int key;
        int val;
        ListNode prev;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }

    }

}
