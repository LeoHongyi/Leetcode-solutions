package algorithms.linkedList;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/40
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * time complexity: traverse, O(one + two)
 *  space complexity: simple if else O(1)
 *  Assumption: two Linked List are not same length
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
public class MergeTwoSortedLinkedLists {
    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode dCur = dummy;
        while (one != null && two != null) {
            if (one.value < two.value) {
                dCur.next = one;
                one = one.next;
            } else {
                dCur.next = two;
                two = two.next;
            }
            dCur = dCur.next;
        }
        if (one == null) {
            dCur.next = two;
        } else if (two == null) {
            dCur.next = one;
        }
        return dummy.next;
    }
}
