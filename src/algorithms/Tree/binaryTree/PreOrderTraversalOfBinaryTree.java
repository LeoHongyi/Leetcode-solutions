package algorithms.tree.binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/655
 * https://app.laicode.io/app/problem/44
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
public class PreOrderTraversalOfBinaryTree {
	List<Integer> results = new ArrayList<Integer>(0);
	public List<Integer> preOrderRecursive(TreeNode root) {
		// Method: recursive
		if (root == null) {
			return results;
		}
		results.add(root.key);
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
		return results;
	}

	public List<Integer> preOrderIterative(TreeNode root) {
		// Method: iterative
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

