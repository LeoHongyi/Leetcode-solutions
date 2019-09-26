package algorithms.tree.binaryTree;

public class SymmetricBinaryTree {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/48
 * method: recursion algorithms.tree,
 * balanced binary algorithms.tree, height = logn,
 * time O(4^log2(n))= O(n^2), space O(logn)
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
    public boolean isSymmetric(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return true;
        }
        return isSymmetric(root, root);
    }
    private boolean isSymmetric(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else {
            return one.key == two.key && isSymmetric(one.left, two.right) && isSymmetric(one.right, two.left);
        }
    }
}
