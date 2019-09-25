package algorithms.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/62
 * Method: DFS,
 *  recursion tree, String set.length() levels,
 *  each level decide to put the index char of the string or not
 */
public class AllSubsetsI {

    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        subSetsDFS(set, 0, new StringBuilder(), result);
        return result;
    }
    private void subSetsDFS(String set, int index, StringBuilder sb, List<String> result) {
        if (index == set.length()) {
            result.add(sb.toString());
            return;
        }
        sb.append(set.charAt(index));
        subSetsDFS(set, index + 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        subSetsDFS(set, index + 1, sb, result);
    }
}