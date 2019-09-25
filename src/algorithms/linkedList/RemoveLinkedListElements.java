package algorithms.linkedList;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/530
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
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        // Write your solution here
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.value == val) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
