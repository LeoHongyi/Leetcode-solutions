package algorithms.recursion;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/139
 * Assumptions: the root is not null
 *  Method: recursion,
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
public class MaximumPathSumBinaryTreeII {
    public int maxPathSum(TreeNode root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        maxPathSumDFS(root, result);
        return result[0];
    }
    private int maxPathSumDFS(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        // step 1: expect from child
        int left = maxPathSumDFS(root.left, result);
        int right = maxPathSumDFS(root.right, result);
        // step 2: process at current level
        left = left < 0 ? 0 : left;
        right = right < 0 ? 0 : right;
        // update result
        result[0] = Math.max(result[0], root.key + left + right);
        // step 3: return to parent
        return Math.max(left, right) + root.key;
    }
}
