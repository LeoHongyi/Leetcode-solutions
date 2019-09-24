package algorithms.tree.binaryTree;

public class LCAIV {

	public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
		// Write your solution here.
		Iterator<TreeNode> i = nodes.iterator();
		TreeNode one = i.next();
		TreeNode two = i.next();
		one = LCA(root, one, two);
		while (i.hasNext()) {
			two = i.next();
			TreeNode LCA = LCA(root, one, two);
			one = LCA;
		}
		return one;
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
}