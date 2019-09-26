package algorithms.tree.binarySearchTree;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/55
 * Method: iteration, in order traverse, using stack, pruning using min max
 **/

import algorithms.tree.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
public class GetKeysInBinarySearchTreeInGivenRange {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        // Write your solution here
        List<Integer> solu = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode validNode = root;
        while(validNode != null || !stack.isEmpty()) {
            while(validNode != null) {
                stack.offerFirst(validNode);
                if (validNode.key <= min) {
                    validNode = null;
                } else {
                    validNode = validNode.left;
                }
            }
            validNode = stack.pollFirst();
            if (min <= validNode.key && validNode.key <= max) {
                solu.add(validNode.key);
            } else if (max < validNode.key) {
                return solu;
            }
            validNode = validNode.right;
        }
        return solu;
    }
}
