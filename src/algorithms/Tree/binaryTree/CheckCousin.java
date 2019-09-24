package algorithms.tree.binaryTree;
import java.util.Queue;
import java.util.ArrayDeque;
/**
 * Description:
 * Check if two nodes are cousins in a Binary algorithms.Tree
 * Given the binary algorithms.Tree and the two nodes say ‘a’ and ‘b’, determine whether the two nodes are cousins of each other or not.
 * Two nodes are cousins of each other if they are at same level and have different parents.
 * Example:
 *
 *                       6
 *
 *                   /     \
 *
 *                3            5
 *
 *             /     \      /    \
 *
 *          7         8    1       2
 * 7 and 1, result is TRUE
 * 3 and 5, result is FALSE
 * 7 and 5, result is FALSE
 * Method: Breadth First Search + check same parent when expanding one node
 * time: O(n), space O(n)
 * **/
class TreeNode {
	int key;
	TreeNode left;
	TreeNode right;
	public TreeNode(int key) {
		this.key = key;
	}
}
public class CheckCousin {
	public boolean checkCousin(TreeNode root, TreeNode a, TreeNode b) {
		// sanity check
		if (a == null || b == null || root == null) {
			return false;
		}
		return checkCousionBFS(root, a, b);
	}
	private boolean checkCousionBFS(TreeNode root, TreeNode a, TreeNode b) {
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int count = 0;
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if (cur.left != null && cur.right != null) {
					if ((cur.left == a && cur.right == b) ||
							(cur.left == b && cur.right == a)) {
						return false;
					}
				}
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
				if (cur == a || cur == b) {
					count++;
				}
				if (count == 2) {
					return true;
				}
			}
			// only one target found in depth i
			if (count == 1) {
				return false;
			}
		}
		return false;
	}
}

