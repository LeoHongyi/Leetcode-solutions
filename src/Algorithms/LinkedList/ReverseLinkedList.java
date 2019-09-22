package Algorithms.LinkedList;

public class ReverseLinkedList {
	static class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value = value;
			next = null;
		}
	}
	public static ListNode reverse(ListNode head) {
		if (head == null || head.next == null){
			return head;
		}
		ListNode newHead = reverse(head.next);//breaking point
//        System.out.println(newHead.value);
		System.out.println(head.value);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
}
