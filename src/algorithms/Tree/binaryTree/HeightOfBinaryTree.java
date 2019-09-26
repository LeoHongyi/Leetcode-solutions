package algorithms.tree.binaryTree;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/60
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
public class HeightOfBinaryTree {
	public int findHeight(TreeNode root) {
		// Write your solution here
		if (root == null) {
			return 0;
		}
		int leftHeight = findHeight(root.left);
		int rightHeight = findHeight(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
