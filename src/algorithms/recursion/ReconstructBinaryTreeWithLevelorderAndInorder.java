package algorithms.recursion;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/215
 * Method: Hashmap store inOrder list <key: num, value: index> for quick check.
 *  Each number in level-order, check their relative position in in-Order list by sequence.
 */

import algorithms.tree.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
public class ReconstructBinaryTreeWithLevelorderAndInorder {
    public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
        // sanity check
        if (inOrder == null || inOrder.length == 0 || levelOrder == null || levelOrder.length == 0) {
            return null;
        }
        // inOrder list <key: num, value: index> for quick check
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i], i);
        }
        // create level-Order list for easier removal
        List<Integer> level = new LinkedList<>();
        for (int num : levelOrder) {
            level.add(num);
        }
        return reconstructDFS(inOrderMap, level);
    }
    private TreeNode reconstructDFS(Map<Integer, Integer> inOrderMap, List<Integer> level) {
        // base case
        if (level.isEmpty()) {
            return null;
        }
        // current level: construct node with the level-Order list first element
        // remove() the first Integer, index++
        TreeNode curr = new TreeNode(level.remove(0));
        // Store the left, right children by index sequence
        List<Integer> left = new LinkedList<>();
        List<Integer> right = new LinkedList<>();
        for (int num : level) {
            // if index before curr node, left child
            if (inOrderMap.get(num) < inOrderMap.get(curr.key)) {
                left.add(num);
            } else {
                // else , right child
                right.add(num);
            }
        }
        // expect from children
        curr.left = reconstructDFS(inOrderMap, left);
        curr.right = reconstructDFS(inOrderMap, right);
        // return to parent
        return curr;
    }
}
