package algorithms.tree.binarySearchTree;
import algorithms.tree.binaryTree.TreeNode;
/**
 * @author Qihao He
 * @date 09/24/2019
 * 2. Distance between two given nodes in a given binary search algorithms.tree.
 *      Assuming:
 *  there is no parent pointer.
 *  both nodes belong to the algorithms.tree.
 *             15
 *          /      \
 *        5         20
 *       /    \
 *     3    10
 *   /   \       /
 *  1   4    8
 *            /   \
 *           7     9
 *
 *  distance(2, 6) = ?
 *
 *  distance(3, 8) = 3
 *  distance(5, 7) = 3
 *  distance(1, 9) = 5
 *
 * Time:       O(height)
 * Space:     O(1)
 */

/**
 * class TreeNode {
 * 	int val;
 * 	TreeNode left;
 * 	TreeNode right;
 */
public class DistanceBetweenTwoNodes {
	public int distanceInBST(TreeNode root, TreeNode n1, TreeNode n2) {
		if (root == null || n1 == null || n2 == null) {
			return -1;
		}
		int distance = -1;
		while (root != null) {
			if (root.key < n1.key && root.key < n2.key) {
				root = root.right;
			} else if (root.key > n1.key && root.key > n2.key) {
				root = root.left;
			} else {
				distance = findDistance(root, n1) + findDistance(root, n2);
			}
		}
		return distance;
	}
	private int findDistance(TreeNode lca, TreeNode n) {
		int distance = 0;
		while (lca != n) {
			if (lca.key < n.key) {
				lca = lca.right;
			} else {
				lca = lca.left;
			}
			distance++;
		}
		return distance;
	}
}




