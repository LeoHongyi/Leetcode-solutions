package algorithms.dynamicProgramming;

public class LongestAscendingSubArray {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/86
 * DP, time O(n), space O(1)
 *  dp[i] represent the longest ascending subArray ends at i
 *  dp[1] = 1
 *  dp[i] = 1,  (array[i] <= array[i - 1])
 *  = dp[i - 1] + 1 (array[i] > array[i - 1])
 */
    public int longest(int[] array) {
        // Write your solution here
        if (array.length == 0) {
            return 0;
        }
        int result = 1;
        int curMax = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                curMax++;
                result = Math.max(result, curMax);
            } else {
                curMax = 1;
            }
        }
        return result;
    }
}
