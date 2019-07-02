package DFS;

import java.util.List;
import java.util.ArrayList;
/**
 * input String: 123450, target int 60
 * result String: 12 + 3 + 45 + 0 = 60
 * Method: DFS
 * number of recursion tree levels: size(input) - 1,
 * each level decide whether to break in the interval or not.
 * Assumption: if can not reach target, return empty String.
 * **/
public class StringAddToTarget {
    public String stringAddtoTarget(String s, int target) {
        if (s == null || s.length() == 0) {
            return s;
        }
        List<String> list = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        boolean find = false;
        stringAddDFS(s, target, 0, 0, list, result, find);
        // if can not reach target, return empty String.
        return find ? addPlus(list) : "";
    }
    private void stringAddDFS(String s, int target, int prev, int index, List<String> list, List<List<String>> result,  boolean find) {
        // base case
        if (index == s.length() - 1 || find) {
            if (isValidList(list, target)) {
                result.add(list);
            }
            return;
        }
        // DFS rule
        list.add(s.substring(prev, index));
        stringAddDFS(s, target, index, index + 1, list, result, find);
        list.remove(list.size() - 1);
        stringAddDFS(s, target, prev, index + 1, list, result, find);
    }
    private boolean isValidList(List<String> list, int target) {

    }
    // if can not reach target, return empty String.
    private String addPlus(List<String> reuslt) {

    }
}