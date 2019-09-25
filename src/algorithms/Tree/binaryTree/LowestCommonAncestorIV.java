package algorithms.tree.binaryTree;

import java.util.List;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/129
 * Assumption: the given k nodes are guaranteed to be in the binary tree
 *  k >= 2
 *  time: O(n), space: O(height)
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
public class LowestCommonAncestorIV {
	public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
		// Write your solution here.
		// base case and corner case
		if (root == null || nodes.contains(root)) {
			return root;
		}
		// expect null or find nodes in the left right child
		TreeNode left = lowestCommonAncestor(root.left, nodes);
		TreeNode right = lowestCommonAncestor(root.right, nodes);
		// both not null
		if (left != null && right != null) {
			return root;
		} else {
			// return the other one when the one is null
			return left == null ? right : left;
		}
	}
}