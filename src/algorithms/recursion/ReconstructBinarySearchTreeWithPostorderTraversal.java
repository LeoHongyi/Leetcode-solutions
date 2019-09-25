package algorithms.recursion;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/211
 * Assumption: the given sequence is not null,
 *  there are no duplicate keys in the binary search tree
 *  Method: recursion,
 *  post order, can scan from right to left.
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
public class ReconstructBinarySearchTreeWithPostorderTraversal {
    public TreeNode reconstruct(int[] post) {
        // Write your solution here
        int[] index = new int[]{post.length - 1};
        return constructor(post, index, Integer.MIN_VALUE);
    }
    private TreeNode constructor(int[] post, int[] index, int min) {
        // base case
        if (index[0] < 0 || post[index[0]] < min) {
            return null;
        }
        // current level
        TreeNode root = new TreeNode(post[index[0]]);
        index[0]--;
        // expect from left, right child
        root.right = constructor(post, index, root.key);
        root.left = constructor(post, index, min);
        return root;
    }
}
