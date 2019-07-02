package BinaryTree;
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
/**
 Method: DFS, top down,
 pass down values:
 1. Parent value, the parent node key value,
 2. length of ascending path ends at Parent node
 **/
public class LongestAscendingPathBinaryTree {
    public int longest(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return 0;
        }
        int[] result = new int[1];
        longestDFS(root, 0, 0, result);
        return result[0];
    }
    private void longestDFS(TreeNode root, int prev, int length, int[] result) {
        if (root == null) {
            return;
        }
        // expect from parent, things to do at current level
        if (root.key > prev) {
            length = length + 1;
            result[0] = Math.max(result[0], length);
        } else {
            length = 1;
        }
        // pass down to children
        longestDFS(root.left, root.key, length, result);
        longestDFS(root.right, root.key, length, result);
    }
}
