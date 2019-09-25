package algorithms.tree.binarySearchTree;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/53
 * method: iteration, 1. find target, hold target's parent, 2. five cases for target's children
 *  time: O(height of BST), space O(1)
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
public class DeleteInBinarySearchTree {
    public TreeNode deleteTree(TreeNode root, int key) {
        // Write your solution here
        if (root == null) {
            return root;
        }
        if (root.key == key) {
            return deleteNode(root);
        }
        TreeNode parent = root;
        //find the target TreeNode and return its parent Node
        while (parent != null) {
            if (parent.key < key) {
                if (parent.right != null && parent.right.key == key) {
                    parent.right = deleteNode(parent.right);
                    break;
                }
                parent = parent.right;
            } else {
                if (parent.left != null && parent.left.key == key) {
                    parent.left = deleteNode(parent.left);
                    break;
                }
                parent = parent.left;
            }
        }
        return root;
    }
    private TreeNode deleteNode(TreeNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            if (root.right.left == null) {
                root.right.left = root.left;
                return root.right;
            } else {
                TreeNode newRoot = findSmallest(root.right);
                newRoot.left = root.left;
                newRoot.right = root.right;
                return newRoot;
            }
        }
    }
    //find the closest (smallest larger) Node in the subTree
    private TreeNode findSmallest(TreeNode root) {
        TreeNode prev = root;
        TreeNode curr = root.left;
        while (curr.left != null) {
            prev = curr;
            curr = curr.left;
        }
        prev.left = curr.right;
        return curr;
    }
}
