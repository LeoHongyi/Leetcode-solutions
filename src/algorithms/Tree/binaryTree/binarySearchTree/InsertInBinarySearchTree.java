package algorithms.tree.binaryTree.binarySearchTree;

public class InsertInBinarySearchTree {
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
	public static TreeNode insert(TreeNode root, int key) {
		// Write your solution here
		TreeNode prev = new TreeNode(0);
		TreeNode curr = root;
		TreeNode newNode = new TreeNode(key);
		if (root == null) {
			if (prev.key < key) {
				prev.right = newNode;
			} else if (prev.key > key) {
				prev.left = newNode;
			}
			return root;
		}
		if (curr.key < key) {
			prev = curr;
			curr = curr.right;
			insert(curr, key);
		}
		if (curr.key > key) {
			prev = curr;
			curr = curr.left;
			insert(curr, key);
		}
		return root;
	}
}
