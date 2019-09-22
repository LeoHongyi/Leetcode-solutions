package Algorithms.BinaryTree;
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