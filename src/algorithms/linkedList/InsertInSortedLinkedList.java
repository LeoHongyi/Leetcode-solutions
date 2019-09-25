package algorithms.linkedList;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/39
 * time complexity: traverse O(n)
 * 	 space complexity: simple if else O(1)
 * 	 Assumption:
 * 	 head may be null
 * 	 value may smaller than head.value,
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
public class InsertInSortedLinkedList {
	public ListNode insert(ListNode head, int value) {
		// Write your solution here
		ListNode valueNode = new ListNode(value);
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		while (cur.next != null && cur.next.value < value) {
			cur = cur.next;
		}
		valueNode.next = cur.next;
		cur.next = valueNode;
		return dummy.next;
	}
}
