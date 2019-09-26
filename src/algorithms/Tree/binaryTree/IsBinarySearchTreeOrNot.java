package algorithms.tree.binaryTree;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/54
 * method: iteration, in order traverse
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
public class IsBinarySearchTreeOrNot {
    public boolean isBST(TreeNode root) {
        // Write your solution here
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        return (min < root.key && root.key < max) &&
                isBST(root.left, min, root.key) &&
                isBST(root.right, root.key, max);
    }
}
