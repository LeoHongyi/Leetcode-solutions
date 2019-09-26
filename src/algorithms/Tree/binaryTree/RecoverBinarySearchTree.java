package algorithms.tree.binaryTree;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/144
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
public class RecoverBinarySearchTree {
    TreeNode one = null, two = null;
    TreeNode prev = null;
    public TreeNode recover(TreeNode root) {
        // Write your solution here
        // 1,2,3,4,5
        // option1: 1,3,2,4,5 相邻两个swap, 在同一次mismatch中被发现，one = prev, two = root
        // option2: 1,4,3,2,5 不相邻两个swap, 会有两次mismatch，第一次中one = prev，第二次中two = root
        // prev has to be global to keep track of the "prev"
        inorder(root);
        if (one != null && two != null) {
            int tmp = one.key;
            one.key = two.key;
            two.key = tmp;
        }
        return root;
    }
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != null) {
            // inorder for BST should always be ascending
            if (prev.key > root.key) {
                if (one == null) {
                    one = prev;
                }
                two = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
