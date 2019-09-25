package algorithms.recursion;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/213
 * Assumption, the given sequences are not null and they have the same length
 *  there are no duplicate keys in the binary tree
 *  Method: recursion
 *  time: O(n), space O(height)
 */

import algorithms.tree.binaryTree.TreeNode;

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
public class ReconstructBinaryTreeWithPreorderAndInorder {
    public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
        // Write your solution here
        // map<key: num, value: index>
        Map<Integer, Integer> inMap = new HashMap<>();
        int n = inOrder.length;
        for (int i = 0; i < n; i++) {
            inMap.put(inOrder[i], i);
        }
        return constructor(inOrder, 0, n - 1, preOrder, 0, n - 1, inMap);
    }
    private TreeNode constructor(int[] in, int inL, int inR,
                                 int[] pre, int preL, int preR, Map<Integer, Integer> inMap) {
        if (inL > inR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int leftSize = inMap.get(root.key) - inL;
        root.left = constructor(in, inL, inL + leftSize - 1, pre, preL + 1, preL + leftSize, inMap);
        root.right = constructor(in, inL + leftSize + 1, inR, pre, preL + leftSize + 1, preR, inMap);
        return root;
    }
}