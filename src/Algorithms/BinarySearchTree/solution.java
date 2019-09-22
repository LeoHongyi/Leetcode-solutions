public class Solution {
  public List<Integer> getRange(TreeNode root, int min, int max) {
    List<Integer> sol = new ArrayList<>();
    TreeNode helper = root;
    Deque<TreeNode> stack = new ArrayDeque<>();
    while (helper!=null || !stack.isEmpty()) {
      while (helper != null ) {
        stack.addFirst(helper);
        if (helper.key <= min) {
          helper = null;
        } else {
          helper = helper.left;
        }
      }
      helper = stack.removeFirst();
      if (min <= helper.key && max >= helper.key) {
        sol.add(helper.key);
      } else if (max < helper.key) {
        return sol;
      }
      helper = helper.right;
    }
    return sol;
  }

}
