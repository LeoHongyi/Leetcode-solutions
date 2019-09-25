package algorithms.linkedList;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/560
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
public class InsertANodeToTheTailOfALinkedList {
    public ListNode insertNode(ListNode head, int target) {
        // Write your solution here
        ListNode newNode = new ListNode(target);
        ListNode cur = head;
        if (head == null){
            newNode.next = null;
            return newNode;
        }
        while (cur.next != null){
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        return head;
    }
}
