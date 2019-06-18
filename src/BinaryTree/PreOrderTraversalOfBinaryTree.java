package BinaryTree;

public class PreOrderTraversalOfBinaryTree {
	//	recursion method
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


