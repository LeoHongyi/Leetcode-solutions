package algorithms.linkedList;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/33
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
public class NumberOfNodes {

    public int numberOfNodes(ListNode head) {
        // Write your solution here
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
