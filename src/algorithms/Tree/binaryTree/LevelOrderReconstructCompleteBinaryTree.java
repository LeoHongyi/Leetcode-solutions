package algorithms.tree.binaryTree;
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
 Method: BFS reconstruct complete tree.
 **/
public class LevelOrderReconstructCompleteBinaryTree {
        public TreeNode construct(int[] level) {
            // Write your solution here
            if (level == null || level.length == 0) {
                return null;
            }
            return constructDFS(level, 0);
        }
        private TreeNode constructDFS(int[] level, int index) {
            if (index >= level.length) {
                return null;
            }
            // current level, generate the current node
            TreeNode curr = new TreeNode(level[index]);
            // expect from children: the node at current index * 2 + 1, index * 2 + 2
            curr.left = constructDFS(level, index * 2 + 1);
            curr.right = constructDFS(level, index * 2 + 2);
            // return the current node to the parent
            return curr;
        }
    }
