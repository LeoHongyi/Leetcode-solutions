package algorithms.recursion;

public class LowestCommonAncestorI {

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/126
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
    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode one, TreeNode two) {
        // Write your solution here.
        // corner case, base case
        if (root == null || root == one || root == two) {
            return root;
        }
        // expect node or null from children
        TreeNode left = lowestCommonAncestor(root.left, one, two);
        TreeNode right = lowestCommonAncestor(root.right, one, two);
        // return root if left child and right child are the target
        if (left != null && right != null) {
            return root;
            // if left child or right child either one is null, return the other one.(including null)
        } else {
            return left == null ? right : left;
        }
    }
}
