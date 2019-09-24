package algorithms.Tree.binaryTree;

public class HeightOgBinaryTree {

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/60
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
    public int findHeight(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return 0;
        }
        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }
}
