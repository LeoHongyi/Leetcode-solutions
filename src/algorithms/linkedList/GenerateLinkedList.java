package algorithms.linkedList;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/554
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
public class GenerateLinkedList {
    public ListNode generate(int n) {
        // Write your solution here
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i = 1; i < n; i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }
}
