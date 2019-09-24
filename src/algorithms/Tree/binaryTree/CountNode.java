package algorithms.tree.binaryTree;

public class CountNode {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/563
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
    public int countNodes(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}