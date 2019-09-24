package algorithms.Tree.binaryTree;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/656
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
public class PostOrderTraversalOfBinaryTree {
	List<Integer> results = new ArrayList<Integer>(0);
	public List<Integer> postOrder(TreeNode root) {
		// Write your solution here
		if (root == null) {
			return results;
		}
		postOrder(root.left);
		postOrder(root.right);
		results.add(root.key);
		return results;
	}
}