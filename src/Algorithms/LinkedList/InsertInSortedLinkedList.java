package Algorithms.LinkedList;

public class InsertInSortedLinkedList {

	static class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value = value;
			next = null;
		}
	}
	public static ListNode insert(ListNode head, int value) {
		// Write your solution here
		ListNode newNode = new ListNode(value);
		//case 1
		if (head == null || value <= head.value){
			newNode.next = head;
			return newNode;
		}
		//case 2
		ListNode curr = head;
		while(curr.next != null && curr.next.value < value){
			curr = curr.next;
		}
		newNode.next = curr.next;
		curr.next = newNode;
		return head;
	}
}