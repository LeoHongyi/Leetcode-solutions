package algorithms.dynamicProgramming;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/1
 * Assumption: a[] is not null.
 *  Method: DP,
 *  dp[i] represents the longest ascending subsequence ends at i, including i.
 *  dp[0] = 1
 *  dp[i] = Max(dp[j]s) + 1, if a[j] < a[i], and 0 < j < i, and find the largest dp[j]
 *  = 1, else
 *  Time: O(n^2), Space: O(n)
 */
public class LongestAscendingSubsequence {
    public int longest(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int length = array.length;
        int[] longestDP = new int[length];
        int result = 1;
        longestDP[0] = 1;
        for (int i = 1; i < length; i++) {
            longestDP[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] < array[i]) {
                    longestDP[i] = Math.max(longestDP[i], longestDP[j] + 1);
                    result = Math.max(longestDP[i], result);
                }
            }
        }
        return result;
    }
}
