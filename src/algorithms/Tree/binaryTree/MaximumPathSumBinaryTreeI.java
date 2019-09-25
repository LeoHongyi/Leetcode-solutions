package algorithms.tree.binaryTree;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/138
 *  Assumption:
 *  Method: recursion, DFS
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
public class MaximumPathSumBinaryTreeI {
    public int maxPathSum(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int[] result = new int[]{Integer.MIN_VALUE};
        maxPathSumDFS(root, result);
        return result[0];
    }
    private int maxPathSumDFS(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        // expect from left and right child,
        // their max sum with one arm
        int left = maxPathSumDFS(root.left, result);
        int right = maxPathSumDFS(root.right, result);
        // find the maximum path sum passing through root
        int curSum = left + right + root.key;
        // update result only when needed
        if ((root.left != null && root.right != null) && result[0] < curSum) {
            result[0] = curSum;
        }
        // return to max (root to leaf path) cost
        if (root.left == null) {
            return root.key + right;
        } else if (root.right == null) {
            return root.key + left;
        } else {
            return Math.max(left, right) + root.key;
        }
    }
}
