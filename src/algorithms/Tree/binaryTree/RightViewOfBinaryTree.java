package algorithms.tree.binaryTree;

import java.util.List;
import java.util.ArrayList;
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
 Method: BFS, add the last element in the queue to the result
 **/
public class RightViewOfBinaryTree {
    public List<Integer> rightView(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            // for each level
            for (int i = 0; i < curSize; i++) {
                TreeNode temp = queue.poll();
                // current level, find the last child in current level
                if (i == curSize - 1) {
                    result.add(temp.key);
                }
                // put children in queue
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return result;
    }
}
