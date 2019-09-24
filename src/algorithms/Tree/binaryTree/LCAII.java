package algorithms.tree.binaryTree;
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
/**
 Method: recursion,
 base case: leaf node
 1. What to expect from children:
 case 1: if no target in left or right or root, return null
 case 2: if left right both are target, return root
 case 3: if one target find, return the target node.
 ** case 4: if the result is one of the target, NOT SURE the other one is in the tree.
 try to find the other target again in the found target.
 2. What to process in current node?
 nothing
 3. What to return to parent node?
 case 1, 2, 3
 **/
public class LCAII {
	public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
		// Write your solution here.
		// corner case
		if (one == null || two == null) {
			return null;
		}
		// one, two both are not null,
		// find the parent Node root
		TreeNodeP root = one;
		while (root.parent != null) {
			root = root.parent;
		}
		TreeNodeP result = LCAHelper(root, one, two);
		// case 4
		if (result == one && LCAHelper(one, two, two) != null) {
			return one;
		} else if (result == two && LCAHelper(two, one, one) != null) {
			return two;
		} else {
			// case 1,2,3
			return result;
		}
	}
	private TreeNodeP LCAHelper(TreeNodeP root, TreeNodeP one, TreeNodeP two) {
		// base case
		if (root == null || root == one || root == two) {
			return root;
		}
		// recursion rule
		TreeNodeP left = LCAHelper(root.left, one, two);
		TreeNodeP right = LCAHelper(root.right, one, two);
		if (left != null && right != null) {
			return root;
		} else {
			return left == null ? right : left;
		}
	}
}

/**
Input: null

input: tree: 8 5 3 2 # # # 6 # # 13 9 # # 17 # # one: 3 two: 12
output: TreeNodeP@49924fad
 expected null, but was:<TreeNodeP@49924fad>
**/

/**
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
/**
  Method: recursion, 
  base case: leaf node
  1. What to expect from children: 
    case 1: if no target in left or right or root, return null
    case 2: if left right both are target, return root
    case 3: if one target find, return the target node.
    ** case 4: if the result is one of the target, NOT SURE the other one is in the tree.
    try to find the other target again in the found target.
  2. What to process in current node?
    nothing
  3. What to return to parent node?
    case 1, 2, 3
**/
/**
public class Solution {
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    // Write your solution here.
    TreeNodeP parentOne = findParent(one);
    TreeNodeP parentTwo = findParent(two);
    if (parentOne == null || parentTwo == null || parentOne != parentTwo) {
      return null;
    } else {
      return LCA(parentOne, one, two);
    }
  }
  private static TreeNodeP LCA(TreeNodeP root, TreeNodeP one, TreeNodeP two) {
    // Write your solution here.
    if (root == null || root == one || root == two) {
      return root;
    }
    TreeNodeP left = LCA(root.left, one, two);
    TreeNodeP right = LCA(root.right, one, two);
    if (left != null && right != null) {
      return root;
    } else {
      return left == null ? right : left;
    }
  }
  private static TreeNodeP findParent(TreeNodeP root) {
    if (root == null) {
      return root;
    }
    while (root.parent != null) {
      root = root.parent;
    }
    return root;
  }
}
**/
