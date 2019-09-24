package algorithms.tree.binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
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
public class PostOrderTraversalOfBinaryTree {
	/**
	 * @author Qihao He
	 * @date 09/24/2019
	 * https://app.laicode.io/app/problem/656
	 * Method: recursive
	 */
	List<Integer> results = new ArrayList<Integer>(0);
	public List<Integer> postOrderRecursive(TreeNode root) {
		// Write your solution here
		if (root == null) {
			return results;
		}
		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		results.add(root.key);
		return results;
	}
	/**
	 * @author Qihao He
	 * @date 09/24/2019
	 * https://app.laicode.io/app/problem/45
	 * Method: iterative
	 */
	public List<Integer> postOrderIterative(TreeNode root) {
		List<Integer> results = new ArrayList<>();
		if (root == null) {
			return results;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode prev = null;
		stack.offerFirst(root);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.peekFirst();
			//going down
			if (prev == null || curr == prev.left || curr == prev.right) {
				if (curr.left != null) {
					stack.offerFirst(curr.left);
				} else if(curr.right != null) {
					stack.offerFirst(curr.right);
				} else {
					results.add(curr.key);
					stack.pollFirst();
				}
				// coming up from left subtree
			} else if (prev == curr.left) {
				if (curr.right != null) {
					stack.offerFirst(curr.right);
				} else {
					results.add(curr.key);
					stack.pollFirst();
				}
				//coming up from right subtree
			} else {
				results.add(curr.key);
				stack.pollFirst();
			}
			prev = curr;
		}
		return results;
	}
}
