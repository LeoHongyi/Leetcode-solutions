package algorithms.linkedlist;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/556
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
public class FindMiddleNodeOfALinkedListOddNumber {
    public ListNode findMiddleNode(ListNode head) {
        // Write your solution here
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
