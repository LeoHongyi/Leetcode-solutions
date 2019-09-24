package algorithms.linkedList;

public class CheckIfLinkedListHasACycle {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/37
 * time complexity: traverse O(n)
 * space complexity: simple if else O(1)
 * Assumption: head may be null
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
    public boolean hasCycle(ListNode head) {
        // write your solution here
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}