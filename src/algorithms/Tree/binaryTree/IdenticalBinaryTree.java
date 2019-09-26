package algorithms.tree.binaryTree;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/49
 * method: recursion algorithms.tree 2^ h, balanced algorithms.tree height logn,
 * time O(n), space O(logn)
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
public class IdenticalBinaryTree {
    public boolean isIdentical(TreeNode one, TreeNode two) {
        // Write your solution here
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else {
            return one.key == two.key &&
                    isIdentical(one.left, two.left) &&
                    isIdentical(one.right, two.right);
        }
    }
}
