package algorithms.linkedlist;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/555
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
public class CountNodesInALinkedList {
    public int count(ListNode head) {
        // Write your solution here
        ListNode cur = head;
        int i = 0;
        while(cur != null){
            i++;
            cur = cur.next;
        }
        return i;
    }
}
