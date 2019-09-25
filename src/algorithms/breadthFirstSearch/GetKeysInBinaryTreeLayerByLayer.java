package algorithms.breadthFirstSearch;

import algorithms.tree.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GetKeysInBinaryTreeLayerByLayer {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/57
 *  Method: BFS1
 *  time: O(n)
 *  space: O(n)
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
    public List<List<Integer>> layerByLayer(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            int queueSize = queue.size();
            for (int j = 0; j < queueSize; j++) {
                TreeNode tmp = queue.poll();
                cur.add(tmp.key);
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            result.add(cur);
        }
        return result;
    }
}

