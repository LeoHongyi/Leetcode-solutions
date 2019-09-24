package algorithms.tree.binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PreOrderTraversalOfBinaryTree {
	/**
	 * @author Qihao He
	 * @date 09/24/2019
	 * https://app.laicode.io/app/problem/655
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
	List<Integer> results = new ArrayList<Integer>(0);
	public List<Integer> preOrderRecursive(TreeNode root) {
		// Write your solution here
		if (root == null) {
			return results;
		}
		results.add(root.key);
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
		return results;
	}

	/**
	 * https://app.laicode.io/app/problem/44
	 method: iteration, pre order traverse,
	 **/
	public List<Integer> preOrderIterative(TreeNode root) {
		// Write your solution here
		List<Integer> results = new ArrayList<>();
		if (root == null) {
			return results;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.offerFirst(root);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pollFirst();
			results.add(curr.key);
			if (curr.right != null) {
				stack.offerFirst(curr.right);
			}
			if (curr.left != null) {
				stack.offerFirst(curr.left);
			}
		}
		return results;
	}
}

