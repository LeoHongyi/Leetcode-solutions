package algorithms.Tree.binaryTree;
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
	//iterative method
	public List<Integer> inOrder(TreeNode root) {
		// Write your solution here
		List<Integer> inorder = new ArrayList<Integer>();
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			} else {
				cur = stack.pollFirst();
				inorder.add(cur.key);
				cur = cur.right;
			}
		}
		return inorder;
	}
}
