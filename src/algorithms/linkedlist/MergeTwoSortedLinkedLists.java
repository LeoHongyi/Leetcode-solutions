package algorithms.linkedlist;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/40
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
        // Write your solution here
        ListNode dummy = new ListNode(0);
        ListNode dummyCur = dummy;
        while (one != null && two != null) {
            if (one.value < two.value) {
                dummyCur.next = one;
                one = one.next;
            } else {
                dummyCur.next = two;
                two = two.next;
            }
            dummyCur = dummyCur.next;
        }
        if (one != null) {
            dummyCur.next = one;
        } else if (two != null) {
            dummyCur.next = two;
        }
        return dummy.next;
    }
}
