package algorithms.tree.binaryTree;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/128
 */

import algorithms.tree.binaryTree.TreeNode;

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

public class LowestCommonAncestorIII {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
		//do LCA if both TreeNode in the algorithms.tree
		if (checkExist(root, one) != null && checkExist(root, two) != null) {
			return LCA(root, one, two);
		} else {
			return null;
		}
	}

	private TreeNode LCA(TreeNode root, TreeNode one, TreeNode two) {
		if (root == null || root == one || root == two) {
			return root;
		}
		TreeNode left = LCA(root.left, one, two);
		TreeNode right = LCA(root.right, one, two);
		if (left == null && right == null) {
			return null;
		} else if (left == null || right == null) {
			return left == null ? right : left;
		} else {
			return root;
		}
	}
	private TreeNode checkExist(TreeNode root, TreeNode one) {
		if (root == null || root == one) {
			return root;
		}
		TreeNode left = checkExist(root.left, one);
		TreeNode right = checkExist(root.right, one);
		if (left == null && right == null) {
			return null;
		} else {
			return left == null ? right : left;
		}
	}

}