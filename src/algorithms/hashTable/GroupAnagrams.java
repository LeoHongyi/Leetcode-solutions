package algorithms.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Qihao He
 * @date 09/29/2019
 * https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] tempCharArray = s.toCharArray();
            Arrays.sort(tempCharArray);
            String keyStr = String.valueOf(tempCharArray);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<String>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}