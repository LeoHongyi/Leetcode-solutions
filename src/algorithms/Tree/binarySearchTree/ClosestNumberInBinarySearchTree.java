package algorithms.tree.binarySearchTree;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/135
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
public class ClosestNumberInBinarySearchTree {
    public int closest(TreeNode root, int target) {
        // Write your solution here
        int[] result = new int[1];
        result[0] = root.key;
        closest(root, target, result);
        return result[0];
    }

    private void closest(TreeNode root, int target, int[] result) {
        if (root == null) {
            return;
        } else if (root.key == target) {
            result[0] = root.key;
            return;
        } else {
            if (Math.abs(result[0] - target) > Math.abs(root.key - target)) {
                result[0] = root.key;
            }
            if (root.key > target) {
                closest(root.left, target, result);
            } else if (root.key < target) {
                closest(root.right, target, result);
            }
        }
    }
}
