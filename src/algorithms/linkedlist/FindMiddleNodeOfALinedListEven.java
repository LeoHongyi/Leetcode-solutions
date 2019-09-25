package algorithms.linkedlist;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/557
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
public class FindMiddleNodeOfALinedListEven {
    public ListNode findMiddleNode(ListNode head) {
        // Write your solution here
        if (head == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
