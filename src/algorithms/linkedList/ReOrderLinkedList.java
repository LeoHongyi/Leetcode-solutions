package algorithms.linkedList;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/530
 */
public class ReOrderLinkedList {
	public ListNode reorder(ListNode head) {
		// Write your solution here
		if (head == null || head.next == null){
			return head;
		}
		ListNode middle = findMiddle(head);
		ListNode secondHead = breakIntoTwoLinkedList(head, middle);
		ListNode newSecondHead = reverse(secondHead);
		ListNode newHead = combine(head, newSecondHead);
		return newHead;
	}

	//find middle
	private ListNode findMiddle(ListNode head){
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	//break into 2 linked list
	private ListNode breakIntoTwoLinkedList(ListNode head, ListNode middle){
		ListNode secondHead = middle.next;
		middle.next = null;
		return secondHead;
	}

	//reverse linked list
	private ListNode reverse(ListNode head){
		if (head == null || head.next == null){
			return head;
		}
		ListNode newHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}

	//combine 2 linked list
	private ListNode combine(ListNode one, ListNode two){
		ListNode dummyNode = new ListNode(0);
		ListNode cur = dummyNode;
		while (one != null && two != null){
			cur.next = one;
			one = one.next;
			cur.next.next = two;
			two = two.next;
			cur = cur.next.next;
		}
		//when one or two first go null
		if (one != null){
			cur.next = one;
		} else {
			cur.next = two;
		}
		return dummyNode.next;
	}
}
/**
 * class ListNode {
 * 	public int value;
 *  	public ListNode next;
 *     public ListNode(int value) {
 *   		this.value = value;
 *   		next = null;
 *     }
 * }
 */

