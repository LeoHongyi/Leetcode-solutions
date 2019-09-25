package algorithms.depthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/530
 * Assumption: there could be duplicate characters in the original set.
 *  Method: DFS
 *  recursion tree: set.length() levels
 *  each level decide to put or not put each char
 */
public class AllSubsetsII {
    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        Arrays.sort(array);
        subSetsDFS(array, new StringBuilder(), 0, result);
        return result;
    }
    private void subSetsDFS(char[] array, StringBuilder sb, int index, List<String> result) {
        if (index == array.length) {
            result.add(sb.toString());
            return;
        }
        sb.append(array[index]);
        subSetsDFS(array, sb, index + 1, result);
        sb.deleteCharAt(sb.length() - 1);
        while (index < array.length - 1 && array[index] == array[index + 1]) {
            index++;
        }
        subSetsDFS(array, sb, index + 1, result);
    }
}