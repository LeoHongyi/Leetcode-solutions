package algorithms.recursion;
import algorithms.tree.binaryTree.TreeNode;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/523
 * The binary tree is not binary search tree, so we can not guarantee
 *  in order traverse will give us sorted in ascending order list.
 *  The example shows the pre order traverse of the tree.
 *  Method: DFS, recursion
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
public class FlattenBinaryTreeToLinkedList {
    public TreeNode flatten(TreeNode root) {
        /**
         * base case: for null node, return null
         */
        if (root == null) {
            return null;
        }
        /**
         *  current level, pre order traverse
         *  recursion rule: left and right are returned flattened subtree,
         *  The rest we need to do is to insert the left between root and
         *  right subtree. Then return root to upper level function.
         */
        TreeNode left = flatten(root.left);
        TreeNode right = flatten(root.right);
        if (left != null) {
            /**
             * find the most right child in the left subtree
             */
            TreeNode next = left;
            while (next.right != null) {
                next = next.right;
            }
            /**
             * reorder the left and right subtree
             */
            next.right = right;
            root.right = left;
            root.left = null;
        }
        return root;
    }
}
