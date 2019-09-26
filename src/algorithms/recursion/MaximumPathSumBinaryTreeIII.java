package algorithms.recursion;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/140
 * Assumption: the root of given binary algorithms.tree is not null
 *  Method: dp, recursion
 *  dp[i] represent the largest sum of the subarray that ends at the current index i (including i)
 *  dp[0] = input[0]
 *  dp[i] = if dp[i - 1] >= 0, then dp[i - 1] + input[i]
 *  else input[i]
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
public class MaximumPathSumBinaryTreeIII {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        maxPathSumDP(root, max, 0);
        return max[0];
    }
    private void maxPathSumDP(TreeNode root, int[] max, int sum) {
        if (root == null) {
            return;
        }
        // induction rule
        sum = Math.max(root.key, root.key + sum);
        // update global max
        max[0] = Math.max(sum, max[0]);
        // pre-order traversal
        maxPathSumDP(root.left, max, sum);
        maxPathSumDP(root.right, max, sum);
    }
}
