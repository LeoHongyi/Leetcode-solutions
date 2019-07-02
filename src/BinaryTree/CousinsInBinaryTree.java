package BinaryTree;

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
/**
 Method: BFS, counter
 **/
public class CousinsInBinaryTree {
    public boolean isCousin(TreeNode root, int a, int b) {
        // Write your solution here
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            // for each level
            for (int i = 0; i < curSize; i++) {
                TreeNode temp = queue.poll();
                // check two children are from one parent
                if (temp.left != null && temp.right != null) {
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
                // 2 cousins are found in the same level
                if (count == 2) {
                    return true;
                }
            }
            // 2 cousins should be on the same level, but only find one, so no need to continue
            if (count == 1) {
                return false;
            }
        }
        // did not find any target
        return false;
    }
}
