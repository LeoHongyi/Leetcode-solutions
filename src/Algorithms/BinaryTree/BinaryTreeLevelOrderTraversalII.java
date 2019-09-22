package Algorithms.BinaryTree;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
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
 Method: BFS, queue for TreeNode, List<Ineger> for result
 if not the last level: (queue still has elements after expand)
 clear the result
 **/
public class BinaryTreeLevelOrderTraversalII {
    public List<Integer> levelOrderBottom(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode temp = queue.poll();
                result.add(temp.key);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            // if current level is not the last level
            if (queue.size() != 0) {
                result.clear();
            }
        }
        return result;
    }
}

