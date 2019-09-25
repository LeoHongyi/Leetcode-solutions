package algorithms.string;

import java.util.HashSet;
import java.util.Set;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/253
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int longest(String input) {
        // Write your solution here
        Set<Character> distinct = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int longest = 0;
        while (fast < input.length()) {
            if (distinct.contains(input.charAt(fast))) {
                distinct.remove(input.charAt(slow++));
            } else {
                distinct.add(input.charAt(fast++));
                longest = Math.max(longest, fast - slow);
            }
        }
        return longest;
    }
}
