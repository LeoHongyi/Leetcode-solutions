package algorithms.Tree.binaryTree;

import java.util.ArrayList;
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
	public List<Integer> preOrder(TreeNode root) {
		// Write your solution here
		if (root == null) {
			return results;
		}
		results.add(root.key);
		preOrder(root.left);
		preOrder(root.right);
		return results;
	}
}


