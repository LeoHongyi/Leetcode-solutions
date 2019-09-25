package algorithms.linkedlist;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/30
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
public class QuickSortLinkedList {
    public ListNode quickSort(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        partition(head, dummy1, dummy2);
        ListNode head1 = quickSort(dummy1.next);
        ListNode head2 = quickSort(dummy2.next);
        ListNode tail = getTail(head1);
        tail.next = head2;
        return head1;
    }
    private ListNode getTail(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    private void partition(ListNode head, ListNode smallDummy, ListNode largeDummy) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode cur = head;
        ListNode pivot = head;
        ListNode smallTail = smallDummy;
        ListNode largeTail = largeDummy;
        while (cur != null) {
            if (cur.value < pivot.value) {
                smallTail.next = cur;
                smallTail = smallTail.next;
            } else {
                largeTail.next = cur;
                largeTail = largeTail.next;
            }
            cur = cur.next;
        }
        smallTail.next = null;
        largeTail.next = null;
    }
}