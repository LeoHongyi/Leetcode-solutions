package algorithms.linkedlist;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/34
 */
public class ReverseLinkedList {
	public ListNode reverseRecusive(ListNode head) {
		if (head == null || head.next == null){
			return head;
		}
		ListNode newHead = reverseRecusive(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}

	//iterative
	// Traverse LinkedList, time O(n), space O(1)
	public ListNode reverseIterative(ListNode root) {
		if (root == null || root.next == null) {
			return root;
		}
		ListNode prev = null;
		ListNode curr = root;
		while (curr != null) {
			  ListNode post = curr.next;
			  curr.next = prev;
			  prev = curr;
			  curr = curr.next;
		}
		return prev;
	}
}
