package algorithms.queue;


import algorithms.linkedlist.ListNode;
/**
 * @author Qihao He
 * @date 09/24/2019
 */
/**
 * public class ListNode {
 *     public int value;
 *     public ListNode next;
 *     public ListNode(int value) {
 *         this.value = value;
 *         next = null;
 *     }
 * }
 */
public class Queue {
	ListNode head;
	ListNode tail;

	public Queue(){
		head = tail = null;
		//head = null;
	}
	public void offer(Integer ele) {
		if (head == null){
			head = new ListNode(ele);
			tail = head;
		} else {
			tail.next = new ListNode(ele);
			tail = tail.next;
		}
	}

	public Integer poll(){
		if (head == null) {
			return null;
		}
		ListNode node = head;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		node.next = null;
		return node.value;
	}

	public Integer peek(){
		if (head == null) {
			return null;
		}
		return head.value;
	}
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}
}
