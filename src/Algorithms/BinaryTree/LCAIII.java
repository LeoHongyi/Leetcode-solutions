package Algorithms.BinaryTree;

public class LCAIII {
	public static class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int key) {
			this.key = key;
		}
	}
	public static TreeNode lowestCommonAncestor(TreeNode root,
																			 TreeNode one, TreeNode two) {
		// write your solution here
		//do LCA if both TreeNode in the tree
		if (checkExist(root, one) != null && checkExist(root, two) != null) {
			return LCA(root, one, two);
		} else {
			return null;
		}
	}

	private static TreeNode LCA(TreeNode root, TreeNode one, TreeNode two) {
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

	private static TreeNode checkExist(TreeNode root, TreeNode one) {
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