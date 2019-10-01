package algorithms.iTasks.amXueHan.oa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/playground/LRBxfw5W
 * Given a string s and an int k, return all unique substrings of s of size k with k distinct characters.
 *
 * Example 1:
 * Input: s = "abcabc", k = 3
 * Output: ["abc", "bca", "cab"]
 *
 * Example 2:
 * Input: s = "abacab", k = 3
 * Output: ["bac", "cab"]
 *
 * Example 3:
 * Input: s = "awaglknagawunagwkwagl", k = 4
 * Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
 *
 * Explanation:
 * Substrings in order are: "wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag", "wagl"
 * "wagl" is repeated twice, but is included in the output once.
 * Constraints:
 *
 * The input string consists of only lowercase English letters [a-z]
 * 0 ≤ k ≤ 26
 */
public class SubStringsOfSizeKWithKDistinctChars {
    /**
     * @author Qihao He
     * @date 09/27/2019
     * Assumption: input string may be null or any length >= k
     * return array following left to right indexes
     * deduplicate the results
     * Method: sliding window, hashtable
     */
    public List<String> kSubString1(String s, int k) {
        // sanity check
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < k) {
            return result;
        }
        Set<String> resultSet = new HashSet<>();
        int len = s.length();
        int left = 0;
        Set<Character> curSet = new HashSet<>();
        for (int right = 0; right < len; right++) {
            while (right < len && right < left + k) {
                if (curSet.add(s.charAt(right))) {
                    right++;
                } else {
                    left++;
                    curSet.remove(s.charAt(left));
                }
            }
            StringBuilder curString = new StringBuilder();
            for (char c : curSet) {
                curString.append(c);
            }
            resultSet.add(curString.toString());
        }
        return new ArrayList<>(result);
    }


    /**
     * UNKNOWN author
     */
    public List<String> kSubString2(String s, int k) {
        Set<Character> window = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            for (; window.contains(s.charAt(end)); start++) {
                window.remove(s.charAt(start));
            }
            window.add(s.charAt(end));
            if (window.size() == k) {
                result.add(s.substring(start, end + 1));
                window.remove(s.charAt(start++));
            }
        }
        return new ArrayList<>(result);
    }
}