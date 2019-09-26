package algorithms.breadthFirstSearch;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/58
 * Method: Deque
 *  odd level: left in, right out, left child first, right child later.
 *  even level: right in, left out, right child first, left child later
 */

import algorithms.tree.binaryTree.TreeNode;

import java.util.*;

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
public class GetKeysInBinaryTreeLayerByLayerZigZagOrder {
    public List<Integer> zigZag(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return new LinkedList<Integer>();
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        deque.offerFirst(root);
        int layer = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                if (layer == 0) {
                    // at even layer, from right to left.
                    TreeNode temp = deque.pollLast();
                    list.add(temp.key);
                    if (temp.right != null) {
                        deque.offerFirst(temp.right);
                    }
                    if (temp.left != null) {
                        deque.offerFirst(temp.left);
                    }
                } else {
                    // at odd layer, from left to right
                    TreeNode temp = deque.pollFirst();
                    list.add(temp.key);
                    if (temp.left != null) {
                        deque.offerLast(temp.left);
                    }
                    if (temp.right != null) {
                        deque.offerLast(temp.right);
                    }
                }
            }
            // set layer odd, even
            layer = 1 - layer;
        }
        return list;
    }
}
