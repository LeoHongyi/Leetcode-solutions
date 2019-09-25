package algorithms.recursion;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/141
 * Assumption: if root == null, return false
 *  Method: DP, similar to the subarray find target sum
 *  time O(n), space O(n)
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
public class BinaryTreePathSumToTargetIII {
    public boolean exist(TreeNode root, int target) {
        // Write your solution here
        if (root == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        return existDFS(root, target, set, 0);
    }
    private boolean existDFS(TreeNode root, int target, Set<Integer> set, int prefixSum) {
        prefixSum += root.key;
        if (set.contains(prefixSum - target)) {
            return true;
        }
        boolean needRemove = set.add(prefixSum);
        if (root.left != null &&  existDFS(root.left, target, set, prefixSum)) {
            return true;
        }
        if (root.right != null &&  existDFS(root.right, target, set, prefixSum)) {
            return true;
        }
        if (needRemove) {
            set.remove(prefixSum);
        }
        return false;
    }
}
