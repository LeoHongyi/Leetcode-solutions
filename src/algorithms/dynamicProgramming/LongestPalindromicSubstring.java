package algorithms.dynamicProgramming;
/**
 * @author Qihao He
 * @date 09/25/2019
 * https://app.laicode.io/app/problem/252
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    /**
     * Solution 1: Dynamic programing
     *
     * m[i][j] represents the longest palindromic substring in s[i:j],
     *  		  this has two properties: 1) s[i:j] itself is a palindrome
     * 								   2) m[i][j] represents the maximum length
     * Base case: m[i][i] = 1
     * Induction rule:
     * 			case 1: s[i:j] is not palindrome (s[i] != s[j]), m[i][j] = 0;
     * 			case 2: s[i:j] is palindrome (s[i] != s[j]), m[i][j] = m[i+1][j-1] if (j-i == 1 || m[i+1][j-1] > 0 ).
     *
     * Note: 1. when i and j is next to each other, they can form palindrome, this is a corner case
     * 		2. have to record the globalMax for length and the corresponding starting index
     * 		3. it is substring, not subsequence
     * 		4. fill the array from down to up, left to right
     *
     *      Time complexity : O(n^2)
     *  Space complexiy : O(n^2)
     */
    public String longestPalindromeDP(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        int[][] m = new int[len][len];
        int globalMax = 1;
        int index = 0;
        for (int i = len - 1; i >= 0; i--) {
            m[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                        (j - i == 1 || m[i + 1][j - 1] > 0)) {
                    m[i][j] = m[i + 1][j - 1] + 2;
                }
                if (m[i][j] > globalMax) {
                    globalMax = m[i][j];
                    index = i;
                }
            }
        }
        return s.substring(index, index + globalMax);
    }

    /**
     * Solution 2: traverse and expand
     * Traverse each possible index as the middle of a palindrom and expand
     * Update the globalMax length and index when possible
     * Note: 1. Corner case with len(s) <= 1, return s
     * 		2. Do expansion on (i, i) e.g. aba,  and (i, i+1), e.g. abba
     *  Time complexity : O(n^2)
     *  Space complexity : O(1)
     */
    private int globalMax = 1;
    private int index = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        if (len == 1) {
            return s;
        }
        for (int i = 0; i < len - 1; i++) {
            if ((len - i) * 2 <= globalMax) {
                break; //pruning
            }
            expand(s, i, i);
            expand(s, i, i + 1);
        }
        return s.substring(index, index + globalMax);
    }

    private void expand(String s, int i, int j) {
        if (s.charAt(i) != s.charAt(j)) {
            return;
        }
        while (i > 0 && j < s.length() - 1 && s.charAt(i - 1) == s.charAt(j + 1)) {
            i--;
            j++;
        }
        if (j - i + 1 > globalMax) {
            globalMax = j - i + 1;
            index = i;
        }
    }
}