package algorithms.tree.binarySearchTree;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/51
 * worst case : skewed tree, height n, time O(n), space O(n)
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
public class InsertInBinarySearchTree {
	public class Solution {
		public TreeNode insert(TreeNode root, int key) {
			// Write your solution here
			if (root == null || root.key == key) {
				return new TreeNode(key);
			} else if (root.key < key) {
				root.right = insert(root.right, key);
			} else {
				root.left = insert(root.left, key);
			}
			return root;
		}
	}
