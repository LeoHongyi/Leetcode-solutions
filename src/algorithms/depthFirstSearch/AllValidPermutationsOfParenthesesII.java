package algorithms.depthFirstSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/179
 * Assumption l (), m <>, n {}
 *  l, m, n >= 0
 *  l + m + n > 0
 *  Method: DFS, stack
 *  1. How many levels in the recursion algorithms.tree? What does it store on each level?
 *  levels = (l + m + n) * 2
 *  2. How many different states should we try to put on each level?
 *  6 () <> {}
 */
public class AllValidPermutationsOfParenthesesII {
    private static final char[] PS = new char[] {'(',')','<','>','{','}'};
    public List<String> validParentheses(int l, int m, int n) {
        // Write your solution here
        int[] remain = new int[] {l, l, m, m, n, n};
        int targetLen = (l + m + n) * 2;
        Deque<Character> stack = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        validParenDFS(new StringBuilder(), targetLen, remain, stack, result);
        return result;
    }
    private void validParenDFS(StringBuilder cur, int targetLen, int[] remain,
                               Deque<Character> stack, List<String> result) {
        if (cur.length() == targetLen) {
            result.add(cur.toString());
            return;
        }
        for (int i = 0; i < remain.length; i++) {
            // even index (<{
            if (i % 2 == 0) {
                if (remain[i] >0) {
                    cur.append(PS[i]);
                    stack.offerFirst(PS[i]);
                    remain[i]--;
                    validParenDFS(cur, targetLen, remain, stack, result);
                    cur.deleteCharAt(cur.length() - 1);
                    stack.pollFirst();
                    remain[i]++;
                }
            } else {
                // odd index )>}, PS[i - 1] = { as PS[i] = }
                if (!stack.isEmpty() && stack.peekFirst() == PS[i - 1]) {
                    cur.append(PS[i]);
                    stack.pollFirst();
                    remain[i]--;
                    validParenDFS(cur, targetLen, remain, stack, result);
                    cur.deleteCharAt(cur.length() - 1);
                    stack.offerFirst(PS[i - 1]);
                    remain[i]++;
                }
            }
        }
    }
}
