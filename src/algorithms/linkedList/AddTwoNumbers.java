package algorithms.linkedList;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/223
 * https://leetcode.com/problems/add-two-numbers/
 * time complexity: traverse, O(one.length + two.length)
 *  space complexity: stack: O(1) heap: O(1)
 *  Assumption:
 *  List one and two can have different length,
 *  length of list is very big, holding value can be greater than Integer.MAX_VALUE
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
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode one, ListNode two) {
		// Write your solution here
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		int sum = 0;
		while (one != null || two != null) {
			sum /= 10;
			if (one != null) {
				sum += one.value;
				one = one.next;
			}
			if (two != null) {
				sum += two.value;
				two = two.next;
			}
			cur.next = new ListNode(sum % 10);
			cur = cur.next;
		}
		if (sum / 10 != 0) {
			cur.next = new ListNode(sum / 10);
		}
		return dummy.next;
	}
}
