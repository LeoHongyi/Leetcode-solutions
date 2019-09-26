package algorithms.tree.binaryTree;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/127
 *  Method: recursion,
 *  base case: leaf node
 *  1. What to expect from children:
 *  case 1: if no target in left or right or root, return null
 *  case 2: if left right both are target, return root
 *  case 3: if one target find, return the target node.
 *  ** case 4: if the result is one of the target, NOT SURE the other one is in the algorithms.tree.
 *  try to find the other target again in the found target.
 *  2. What to process in current node?
 *  nothing
 *  3. What to return to parent node?
 *  case 1, 2, 3
 */
/**
 * public class TreeNodeP {
 *   public int key;
 *   public TreeNodeP left;
 *   public TreeNodeP right;
 *   public TreeNodeP parent;
 *   public TreeNodeP(int key, TreeNodeP parent) {
 *     this.key = key;
 *     this.parent = parent;
 *   }
 * }
 */
public class LowestCommonAncestorII {
	public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
		// Write your solution here.
		int lengthOne = getLength(one);
		int lengthTwo = getLength(two);
		if (lengthOne >= lengthTwo) {
			return mergePath(two, one, lengthOne - lengthTwo);
		} else {
			return mergePath(one, two, lengthTwo - lengthOne);
		}
	}
	private TreeNodeP mergePath(TreeNodeP shorter, TreeNodeP longer, int diff) {
		while (diff > 0) {
			longer = longer.parent;
			diff--;
		}
		while(longer != shorter) {
			longer = longer.parent;
			shorter = shorter.parent;
		}
		return longer;
	}
	private int getLength(TreeNodeP root) {
		int length = 0;
		while(root != null) {
			root = root.parent;
			length++;
		}
		return length;
	}
}
