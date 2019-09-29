package algorithms.string;

import java.util.*;
/**
 * @author Qihao He
 * @date 09/29/2019
 * https://leetcode.com/problems/most-common-word/
 */
public class MostCommonWord {
    /**
     * @author: UNKNOWN
     * method: regular expression
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        // \w, \W: ANY ONE word/non-word character. For ASCII, word characters are [a-zA-Z0-9_]
        // \s, \S: ANY ONE space/non-space character. For ASCII, whitespace characters are [ \n\r\t\f]
        String[] words = paragraph.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
        for (String w : words) {
            if (!ban.contains(w)) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
        }
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
    /**
     * Method: hash map, max heap
     */
}