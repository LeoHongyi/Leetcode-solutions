package algorithms.tree.binaryTree;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/46
 *  Method: recursion
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
public class CheckIfBinaryTreeIsBalanced {
    public boolean isBalanced(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return true;
        }
        if (checkHeightAndBalance(root) != -1) {
            return true;
        }
        return false;
    }
    private int checkHeightAndBalance(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // expect from left and right child
        int left = checkHeightAndBalance(root.left);
        int right = checkHeightAndBalance(root.right);
        // process at current level.
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return  -1;
        }
        // return to parent
        return Math.max(left, right) + 1;
    }
}
