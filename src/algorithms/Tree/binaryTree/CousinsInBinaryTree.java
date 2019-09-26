package algorithms.tree.binaryTree;
/**
 * @author Qihao He
 * @date 09/24/2019
 *  Method: BFS, counter
 */

import algorithms.tree.binaryTree.TreeNode;

import java.util.Queue;
import java.util.ArrayDeque;

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
public class CousinsInBinaryTree {
    public boolean isCousin(TreeNode root, int a, int b) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                // for each level
                TreeNode temp = queue.poll();
                if (temp.left != null && temp.right != null) {
                    // check two children are from one parent
                    if ((temp.left.key == a && temp.right.key == b) ||
                            (temp.left.key == b && temp.right.key == a)) {
                        return false;
                    }
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                    if (temp.left.key == a || temp.left.key == b) {
                        count++;
                    }
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                    if (temp.right.key == a || temp.right.key == b) {
                        count++;
                    }
                }
                if (count == 2) {
                    // 2 cousins are found in the same level
                    return true;
                }
            }
            if (count == 1) {
                // 2 cousins should be on the same level, but only find one, so no need to continue
                return false;
            }
        }
        // did not find any target
        return false;
    }
}
