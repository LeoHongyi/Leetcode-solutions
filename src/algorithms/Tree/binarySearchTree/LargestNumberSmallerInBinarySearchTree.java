package algorithms.tree.binarySearchTree;


import algorithms.tree.binaryTree.TreeNode;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/136
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
public class LargestNumberSmallerInBinarySearchTree {
    public int largestSmaller(TreeNode root, int target) {
        int[] max = new int[]{Integer.MIN_VALUE};
        largestSmaller(root, target, max);
        return max[0];
    }
    private static void largestSmaller(TreeNode root, int target, int[] max) {
        if (root == null) {
            return;
        }
        if (root.key < target) {
            if (max[0] < root.key) {
                max[0] = root.key;
            }
            largestSmaller(root.right, target, max);
        } else if (root.key >= target) {
            largestSmaller(root.left, target, max);
        }
    }
}
