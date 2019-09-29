package algorithms.linkedList;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/131
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
/**
 * class Node {
 *     public int val;
 *     public Node next;
 *     public Node random;
 *
 *     public Node() {}
 *
 *     public Node(int _val,Node _next,Node _random) {
 *         val = _val;
 *         next = _next;
 *
 *         random = _random;
 *     }
 * }
 */
public class RandomListNode {
    public int value;
    public RandomListNode next;
    public RandomListNode random;
    public RandomListNode(int value) {
        this.value = value;
    }
}