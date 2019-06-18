package LinkedList;

public class LinkedListInsertAtIndex {
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
	public static ListNode insert(ListNode head, int index, int value) {
		// Write your solution here
		ListNode newNode = new ListNode(value);
		ListNode cur = head;
		if (cur == null || index == 0) {
			cur = newNode.next;
			return newNode;
		} else {
			int i = 1;
			while(cur != null && cur.next != null) {
				if (index == i) {
					newNode.next = cur.next;
					cur.next = newNode;
					return head;
				}
				i++;
				cur = cur.next;
			}
			return head;
		}
	}
}
