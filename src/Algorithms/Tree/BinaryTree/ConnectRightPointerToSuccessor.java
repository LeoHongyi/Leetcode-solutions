package Algorithms.Tree.BinaryTree;
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
 Method: Algorithms.DepthFirstSearch, In order traverse
 print tree in in-order traverse:
 1 2 7 11  35  15  29  40
 T   T     T   T
 Target: for each node that does not has a right children,
 Action: connect it's right children with the following node in in-order sequence.
 **/
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
    // maintain the top of the stack is the left most node left unprocessed
    private void pushLeft(TreeNode root, Deque<TreeNode> stack) {
        while (root != null) {
            stack.offerFirst(root);
            root = root.left;
        }
    }
}