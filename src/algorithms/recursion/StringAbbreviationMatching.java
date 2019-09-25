package algorithms.recursion;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/292
 * Method: DFS, recursion
 */
public class StringAbbreviationMatching {
    public boolean match(String input, String pattern) {
        // Write your solution here
        return match(input, pattern, 0, 0);
    }
    private boolean match(String s, String t, int si, int ti) {
        // only when we run out of s and t at the same time,
        // there is a match.
        if (si == s.length() && ti == t.length()) {
            return true;
        }
        // if we run of one of s and t but there is still some
        // characters left for the other one, we can not find the match.
        if (si >= s.length() || ti >= t.length()) {
            return false;
        }
        // case 1. if the current character in t is not a digit.
        if (t.charAt(ti) < '0' || t.charAt(ti) > '9') {
            if (s.charAt(si) == t.charAt(ti)) {
                return match(s, t, si + 1, ti + 1);
            }
            return false;
        }
        // case 2. if the current character in t is a digit.
        // we need to find in total what is the number.
        int count = 0;
        while (ti < t.length() && t.charAt(ti) >= '0' && t.charAt(ti) <= '9') {
            count = count * 10 + (t.charAt(ti) - '0');
            ti++;
        }
        return match(s, t, si + count, ti);
    }
}
