package algorithms.tree.binaryTree;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/214
 * Method: recursion, time: O(n), space:O(height)
 */

import java.util.HashMap;
import java.util.Map;

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
public class ReconstructBinaryTreeWithPostorderAndInorder {
    public TreeNode reconstruct(int[] inOrder, int[] postOrder) {
        // Write your solution here
        int n = inOrder.length;
        // map<key: num, value: index>
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inMap.put(inOrder[i], i);
        }
        return constructor(inMap, postOrder, 0, n - 1, inOrder, 0, n - 1);
    }
    private TreeNode constructor(Map<Integer, Integer> inMap, int[] post, int postL, int postR,
                                 int[] in, int inL, int inR) {
        if (inL > inR) {
            return null;
        }
        TreeNode root = new TreeNode(post[postR]);
        int leftSize = inMap.get(root.key) - inL;
        root.right = constructor(inMap, post, postL + leftSize, postR - 1, in, inL + leftSize + 1, inR);
        root.left = constructor(inMap, post, postL, postL + leftSize - 1, in, inL, inL + leftSize - 1);
        return root;
    }
}
