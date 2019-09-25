package algorithms.linkedlist;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/306
 * Method: iterative, can not use recursion since space complexity must be O(1)
 *  step 1: get the middle of the Linked List. (2 pointers)
 *  step 2: reverse the second half of the linked list.
 *  step 3: check if the first half and second half are identical.
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
public class CheckIfLinkedListIsPalindrome {
    public boolean isPalindrome(ListNode head) {
        // Write your solution here
        if (head == null) {
            return true;
        }
        ListNode mid = getMiddle(head);
        ListNode head2 = mid.next;
        // break from the mid ListNode and form 2 List
        mid.next = null;
        ListNode newHead2 = reverse(head2);
        return checkPalindrome(head, newHead2);
    }
    private ListNode getMiddle(ListNode root) {
        ListNode fast = root;
        while (fast.next != null && fast.next.next != null) {
            root = root.next;
            fast = fast.next.next;
        }
        return root;
    }
    private ListNode reverse(ListNode root) {
        ListNode prev = null;
        while (root != null) {
            ListNode next = root.next;
            root.next = prev;
            prev = root;
            root = next;
        }
        return prev;
    }
    private boolean checkPalindrome(ListNode root1, ListNode root2) {
        while (root1 != null && root2 != null) {
            if (root1.value != root2.value) {
                return false;
            } else {
                root1 = root1.next;
                root2 = root2.next;
            }
        }
        return true;
    }
}
