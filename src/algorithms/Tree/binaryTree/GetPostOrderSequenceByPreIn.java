package algorithms.tree.binaryTree;

import java.util.List;


/**
 Method: hashmap for in-Order <key: num, value: index> for quick check index.
 list of pre.
 **/
public class GetPostOrderSequenceByPreIn {
    public int[] postOrder(int[] pre, int[] in) {
        // Write your solution here
        // sanity check
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return new int[0];
        }
        List<Integer> preList = new LinkedList<>();
        for (int num : pre) {
            preList.add(num);
        }
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inOrderMap.put(in[i], i);
        }
        List<Integer> postList = postOrder(inOrderMap, preList);
        int[] result = new int[postList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = postList.get(i);
        }
        return result;
    }
    private List<Integer> postOrder(Map<Integer, Integer> inOrderMap, List<Integer> preList) {
        // base case
        if (preList.isEmpty()) {
            return new ArrayList<>();
        }
        // current level, rearrange the sequence of the root and left, right child
        int root = preList.get(0);
        List<Integer> left = new LinkedList<>();
        List<Integer> right = new LinkedList<>();
        for (int num : preList) {
            if (inOrderMap.get(num) < inOrderMap.get(root)) {
                left.add(num);
            } else {
                right.add(num);
            }
        }
        left = postOrder(inOrderMap, left);
        right = postOrder(inOrderMap, right);
        right.add(root);
        left.addAll(right);
        return left;
    }
}

