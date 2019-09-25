package algorithms.hashTable;
import algorithms.linkedList.RandomListNode;

import java.util.HashMap;
import java.util.Map;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/131
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
        // Write your solution here.
        if (head == null) {
            return null;
        }
        // lookup map to avoid duplicate.
        // key: original node. value: copied node.
        Map<RandomListNode, RandomListNode> lookup = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.value);
        lookup.put(head, newHead);
        RandomListNode cur = newHead;
        while (head != null) {
            if (head.next != null) {
                // copy next
                if (!lookup.containsKey(head.next)) {
                    // hasn't been copied over due to random pointer.
                    lookup.put(head.next, new RandomListNode(head.next.value));
                }
                cur.next = lookup.get(head.next);
            }
            // copy random
            if (head.random != null) {
                if (!lookup.containsKey(head.random)) {
                    // hasn't been copied over previously
                    lookup.put(head.random, new RandomListNode(head.random.value));
                }
                cur.random = lookup.get(head.random);
            }
            head = head.next;
            cur = cur.next;
        }
        return newHead;
    }
}
