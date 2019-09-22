package Algorithms.Tree.BinaryTree;
import java.util.List;
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
public class InOrderTraversalOfBinaryTree {
	//iterative method
	public List<Integer> inOrder(TreeNode root) {
		// Write your solution here
		List<Integer> inorder = new ArrayList<Integer>();
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			} else {
				cur = stack.pollFirst();
				inorder.add(cur.key);
				cur = cur.right;
			}
		}
		return inorder;
	}
}

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
	// Method with pushLeft helper
	public List<Integer> inOrder(TreeNode root) {
		// Write your solution here
		Deque<TreeNode> stack = new ArrayDeque<>();
		List<Integer> result = new ArrayList<>();
		pushLeft(root, stack);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pollFirst();
			result.add(cur.key);
			if (cur.right != null) {
				cur = cur.right;
				pushLeft(cur, stack);
			}
		}
		return result;
	}
	// maintain top Node in stack is the left most Node
	private void pushLeft(TreeNode cur, Deque<TreeNode> stack) {
		while (cur != null) {
			stack.offerFirst(cur);
			cur = cur.left;
		}
	}
}
