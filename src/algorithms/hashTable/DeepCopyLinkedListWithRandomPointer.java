package algorithms.hashTable;
import algorithms.linkedList.RandomListNode;

import java.util.HashMap;
import java.util.Map;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/131
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
/**
 * class RandomListNode {
 *   public int value;
 *   public RandomListNode next;
 *   public RandomListNode random;
 *   public RandomListNode(int value) {
 *     this.value = value;
 *   }
 * }
 */
public class DeepCopyLinkedListWithRandomPointer {
    public RandomListNode copy(RandomListNode head) {
        if (head == null) {
            return head;
        }
        /**
         * K: original Node, V: clone Node
         */
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(head.value);
        map.put(head, dummy);
        RandomListNode cur = dummy;
        while (head != null) {
            if (head.next != null) {
                if (!map.containsKey(head.next)) {
                    map.put(head.next, new RandomListNode(head.next.value));
                }
                cur.next = map.get(head.next);
            }
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.next, new RandomListNode(head.random.value));
                }
                cur.random = map.get(head.random);
            }
            head = head.next;
            cur = cur.next;
        }
        return dummy;
    }
    /**
     * Definition for a Node.
     * class Node {
     *     public int val;
     *     public Node next;
     *     public Node random;
     *
     *     public Node() {}
     *
     *     public Node(int _val,Node _next,Node _random) {
     *         val = _val;
     *         next = _next;
     *         random = _random;
     *     }
     * };
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        /**
         K: original Node, V: clone Node
         */
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(head.val, head.next, head.random);
        map.put(head, dummy);
        Node cur = dummy;
        while (head != null) {
            if (head.next != null) {
                if (!map.containsKey(head.next)) {
                    map.put(head.next, new Node(head.next.val, head.next.next, head.next.random));
                }
                cur.next = map.get(head.next);
            }
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.next, new Node(head.random.val, head.random.next, head.random.random));
                }
                cur.random = map.get(head.random);
            }
            head = head.next;
            cur = cur.next;
        }
        return dummy;
    }

    class Node {
        public int val;
        public Node next;
        public Node random;
        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}