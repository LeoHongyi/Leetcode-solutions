// 2. Distance between two given nodes in a given binary search tree. 
//     Assuming:
// there is no parent pointer. 
// both nodes belong to the tree.
//            15
//         /      \
//       5         20
//      /    \
//    3    10
//  /   \       /   
// 1   4    8
//           /   \
//          7     9

// distance(2, 6) = ?

// distance(3, 8) = 3
// distance(5, 7) = 3
// distance(1, 9) = 5


class TreeNode {
	int val;
	algorithms.Tree.BinaryTree.TreeNode left;
	algorithms.Tree.BinaryTree.TreeNode right;
}


public int distanceInBST(algorithms.Tree.BinaryTree.TreeNode root, algorithms.Tree.BinaryTree.TreeNode n1, algorithms.Tree.BinaryTree.TreeNode n2) {
	if (root == null || n1 == null || n2 == null) return -1;
	int distance = -1;
	while (root != null) {
	if (root.val < n1.val && root.val < n2.val) {
	root = root.right;
} else if (root.val > n1.val && root.val > n2.val) {
	root = root.left;
} else {
	distance = findDistance(root, n1) + findDistance(root, n2);
}
}
return distance;
}
private int findDistance(algorithms.Tree.BinaryTree.TreeNode lca, algorithms.Tree.BinaryTree.TreeNode n) {
	int distance = 0;
	while (lca != n) {
	if (lca.val < n.val) {
		lca = lca.right;
} else {
	lca = lca.left;
}
distance++;
}
	return distance;
}

Time:       O(height)
Space:     O(1)
