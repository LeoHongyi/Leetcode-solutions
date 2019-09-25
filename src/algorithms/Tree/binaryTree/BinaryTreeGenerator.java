package algorithms.tree.binaryTree;

import java.util.List;
import java.util.ListIterator;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/142
 * Assumption: input List<algorithms.string> should be in Breadth First Search Order
 * # in the List<algorithms.string> should be consider as null.
 * output is the TreeNode newNode.
 */
public class BinaryTreeGenerator {
	public TreeNode binaryTreeGenerator (List<String> list) {
		if (list == null) {
			return null;
		}
		ListIterator<String> iterator = list.listIterator();
		Integer value = Integer.valueOf(iterator.next());
		TreeNode root = new TreeNode(value);
		int count = 0;
		while (iterator.hasNext()) {
			count++;
			if (count < list.size()) {
				iterator.next();
			}
		}
		return root;
	}
}


