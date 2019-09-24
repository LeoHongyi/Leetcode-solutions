package algorithms.tree.binaryTree;
import java.util.*;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/654
 */
/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class InOrderTraversalOfBinaryTree {
	/**
	 * https://app.laicode.io/app/problem/43
	 * iterative method
	 */
	public List<Integer> inOrderIterative(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		List<Integer> result = new ArrayList<>();
		pushLeft(root, stack);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pollFirst();
			result.add(cur.key);
			if (cur.right != null) {
				cur = cur.right;
				pushLeft(cur, stack);
			}
		}
		return result;
	}
	// maintain top Node in stack is the left most Node
	private void pushLeft(TreeNode cur, Deque<TreeNode> stack) {
		while (cur != null) {
			stack.offerFirst(cur);
			cur = cur.left;
		}
	}
}