package algorithms.tree.binaryTree;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/50
 * base case:
 * null && null
 * null || null
 * !null && !null
 * worst case: balanced binary algorithms.tree, height log2(n), time O (4^log2(n)) = n^2, space O(height), O(logn)
 * best case: skewed algorithms.tree height O(n), time O(n), space O(height), O(n)
 * recursion algorithms.tree:
 *                                   one two
 *                            one.key, two.key
 *    one.left, two.left        one.right, two.right         one.left, two.right        one.right, two.left
 *     one.key, two.key          one.key, two.key            one.key, two.key            one.key, two.key
 */

import algorithms.tree.binaryTree.TreeNode;

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

public class TweakedIdenticalBinaryTrees {
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        // Write your solution here
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else {
            return one.key == two.key &&
                    ((isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)) ||
                            (isTweakedIdentical(one.right, two.left) && isTweakedIdentical(one.left, two.right)));
        }
    }
}

