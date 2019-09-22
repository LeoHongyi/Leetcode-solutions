/**
 Assumption: root is not null, no duplicate keys in the BST.
 Method 2: iterative in order traverse tree
 **/
public class ClosestKValues {
	public int[] closestKValues(TreeNode root, double target, int k) {
		// Write your solution here
		Deque<TreeNode> stack = new ArrayDeque<>();
		Queue<Integer> queue = new ArrayDeque<>();
		inOrderTraverse(root, queue, stack, target, k);
		int[] result = new int[queue.size()];
		int i = 0;
		while (!queue.isEmpty()) {
			result[i++] = queue.poll();
		}
		return result;
	}
	private void inOrderTraverse(TreeNode root, Queue<Integer> queue, Deque<TreeNode> stack, double target, int k) {
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			} else {
				// cur == null
				// cur's parent is now the left most node, parent may have right child
				cur = stack.pollFirst();
				if (queue.size() < k) {
					// result is not full
					queue.offer(cur.key);
				} else if (Math.abs(queue.peek() - target) > Math.abs(cur.key - target)) {
					// result is full, new add is closer to target
					queue.poll();
					queue.offer(root.key);
				} else {
					// result is full, new add is further to target than the first
					return;
				}
				cur = cur.right;
			}
		}
		return;
	}
}