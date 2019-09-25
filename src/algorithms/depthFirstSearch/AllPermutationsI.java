package algorithms.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/64
 * Method: DFS with SWAP SWAP
 * Assumption: no duplicate characters
 */
public class AllPermutationsI {
    public List<String> permutations(String set) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        DFS(array, 0, result);
        return result;
    }
    private void DFS(char[] array, int level, List<String> result) {
        if (level == array.length) {
            result.add(new String(array));
            return;
        }
        for (int i = level; i < array.length; i++) {
            swap(array, level, i);
            DFS(array, level + 1, result);
            swap(array, level, i);
        }
    }
    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
