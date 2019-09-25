package algorithms.tree.binaryTree;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/178
 * Method: Iterative, time: O(n), space: O(1)
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
public class ReverseBinaryTreeUpSideDown {
    public TreeNode reverse(TreeNode root) {
        // Write your solution here
        TreeNode prev = null;
        TreeNode prevRight = null;
        while (root != null) {
            // safe the reference of the left, right child
            TreeNode left = root.left;
            TreeNode right = root.right;
            // things to process at current level
            root.left = prev;
            root.right = prevRight;
            // Move on to the next level
            prevRight = right;
            prev = root;
            root = left;
        }
        return prev;
    }
}
