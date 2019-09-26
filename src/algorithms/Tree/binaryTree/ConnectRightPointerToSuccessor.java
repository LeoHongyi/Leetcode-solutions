package algorithms.tree.binaryTree;
/**
 * @author Qihao He
 * @date 09/24/2019
 * Method: algorithms.depthFirstSearch, In order traverse
 *  print algorithms.tree in in-order traverse:
 *  1 2 7 11  35  15  29  40
 *  T   T     T   T
 *  Target: for each node that does not has a right children,
 *  Action: connect it's right children with the following node in in-order sequence.
 */

import java.util.ArrayDeque;
import java.util.Deque;

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
public class ConnectRightPointerToSuccessor {
    public void connect(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode prev = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        pushLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pollFirst();
            if (prev != null && prev.right == null) {
                prev.right = curr;
            }
            prev = curr;
            pushLeft(curr.right, stack);
        }
    }

    private void pushLeft(TreeNode root, Deque<TreeNode> stack) {
        // maintain the top of the stack is the left most node left unprocessed
        while (root != null) {
            stack.offerFirst(root);
            root = root.left;
        }
    }
}