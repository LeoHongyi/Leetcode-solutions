package algorithms.depthFirstSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutationsII {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/65
     */
    public List<String> permutations(String input) {
        // Write your solution here
        if (input == null) {
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<>();
        char[] array = input.toCharArray();
        DFS(array, 0, result);
        return result;
    }
    private void DFS(char[] array, int level, List<String> result) {
        if (level == array.length) {
            result.add(new String(array));
            return;
        }
        Set<Character> count = new HashSet<>();
        for (int i = level; i < array.length; i++) {
            if (count.add(array[i])) {
                swap(array, i, level);
                DFS(array, level + 1, result);
                swap(array, i, level);
            }
        }
    }
    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}