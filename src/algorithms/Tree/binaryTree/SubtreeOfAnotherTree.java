package algorithms.tree.binaryTree;
/**
 * @author Qihao He
 * @date 09/29/2019
 * https://leetcode.com/problems/subtree-of-another-tree/
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // sanity check
        if (s == null || t == null) {
            return false;
        }
        if (isIdentical(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isIdentical(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.key != t.key) {
            return false;
        }
        return isIdentical(s.left, t.left) && isIdentical(s.right, t.right);
    }
}