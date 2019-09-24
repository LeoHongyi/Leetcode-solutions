package algorithms.linkedList;

public class PartitionLinkedList {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/42
 * time complexity: traverse O(n)
 *  space complexity: simple if else, stack: O(1), heap O(1)
 *  Assumption:
 *  head may be null
 *  duplicate target
 *  To do: Need to ground one tail in case of cycled linked List.
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
    public ListNode partition(ListNode head, int target) {
        // Write your solution here
        ListNode dummyS = new ListNode(0);
        ListNode dummySCur = dummyS;
        ListNode dummyL = new ListNode(0);
        ListNode dummyLCur = dummyL;
        while (head != null) {
            if (head.value < target) {
                dummySCur.next = head;
                head = head.next;
                dummySCur = dummySCur.next;
            } else {
                dummyLCur.next = head;
                head = head.next;
                dummyLCur = dummyLCur.next;
            }
        }
        dummyLCur.next = null;
        dummySCur.next = dummyL.next;
        return dummyS.next;
    }
}
