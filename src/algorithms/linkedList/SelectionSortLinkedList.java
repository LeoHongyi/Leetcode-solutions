package algorithms.linkedList;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/28
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
public class SelectionSortLinkedList {
    public ListNode selectionSort(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curParent = dummy;
        ListNode cur = head;
        while (cur != null) {
            ListNode minParent = curParent;
            ListNode min = cur;
            ListNode jParent = cur;
            ListNode j = cur.next;
            while (j != null) {
                if (j.value < min.value) {
                    minParent = jParent;
                    min = j;
                }
                jParent = j;
                j = j.next;
            }
            //swap nodes
            curParent.next = min;
            minParent.next = cur;
            ListNode temp = min.next;
            min.next = cur.next;
            cur.next = temp;
            //update cur
            curParent = min;
            cur = min.next;
        }
        return dummy.next;
    }
}
