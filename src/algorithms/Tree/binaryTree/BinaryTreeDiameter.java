package algorithms.tree.binaryTree;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/142
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
public class BinaryTreeDiameter {

    public int diameter(TreeNode root) {
        // Write your solution here
        int[] max = new int[1];
        diameter(root, max);
        return max[0];
    }
    private int diameter(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = diameter(root.left, max);
        int right = diameter(root.right, max);
        if (root.left != null && root.right != null) {
            max[0] = Math.max(max[0], left + right + 1);
            return Math.max(left, right) + 1;
        }
        return root.left == null ? right + 1 : left + 1;
    }
}
