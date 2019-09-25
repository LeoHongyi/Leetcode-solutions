package algorithms.breadthFirstSearch;

import algorithms.tree.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/47
 * If a complete Binary tree, if a null apeared in expansion,
 * no more value in expansion allowed.
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
public class CheckIfBinaryTreeIsCompleted {
    public boolean isCompleted(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean allowNextChild = true;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // cur does not have any children
            if (cur.left == null  && cur.right == null) {
                allowNextChild = false;
                continue;
            } else {
                // not allowedNextChild but cur has child, or cur has rightchild
                if (!allowNextChild || cur.left == null && cur.right != null) {
                    return false;
                    // cur has left child
                } else if (cur.left != null && cur.right == null) {
                    allowNextChild = false;
                    queue.add(cur.left);
                    // cur has 2 children
                } else {
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }
        }
        return true;
    }
}