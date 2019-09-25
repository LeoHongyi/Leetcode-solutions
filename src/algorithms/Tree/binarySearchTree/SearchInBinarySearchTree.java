package algorithms.tree.binarySearchTree;

import algorithms.tree.binaryTree.TreeNode;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/52
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
public class SearchInBinarySearchTree {
    public TreeNode search(TreeNode root, int key) {
        // Write your solution here
        if (root == null) {
            return null;
        }
        TreeNode leftSearch = search(root.left, key);
        TreeNode rightSearch = search(root.right, key);
        if (leftSearch == null && rightSearch == null && root.key != key) {
            return null;
        } else if (leftSearch == null && rightSearch == null) {
            return root;
        } else {
            return leftSearch == null ? rightSearch : leftSearch;
        }
    }
}
