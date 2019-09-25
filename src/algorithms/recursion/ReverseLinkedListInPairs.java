package algorithms.recursion;

import algorithms.linkedList.ListNode;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/35
 */


/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class ReverseLinkedListInPairs {
    public ListNode reverseInPairs(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy3 = reverseInPairs(head.next.next);
        ListNode dummy1 = head.next;
        ListNode dummy2 = head;
        dummy2.next = dummy1.next;
        dummy1.next = dummy2;
        dummy2.next = dummy3;
        return dummy1;
    }
}
