package algorithms.tree.binarySearchTree;

import algorithms.tree.binaryTree.TreeNode;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/368
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
public class LowestCommonAncestorBinarySearchTreeI {
    public TreeNode lca(TreeNode root, int p, int q) {
        //know p, q which one is smaller
        if (q < p) {
            int temp = p;
            p = q;
            q = temp;
        }
        while (true) {
            if (root.key >= p && root.key <= q) {
                return root;
            } else if (root.key < p) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }
}
