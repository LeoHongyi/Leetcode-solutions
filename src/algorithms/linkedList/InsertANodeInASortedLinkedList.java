package algorithms.linkedList;

public class InsertANodeInASortedLinkedList {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/559
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
    public ListNode insertNode(ListNode head, int target) {
        // Write your solution here
        ListNode newNode = new ListNode(target);
        ListNode cur = head;
        while (cur.next != null && cur.next.value < target){
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        return head;
    }
}
