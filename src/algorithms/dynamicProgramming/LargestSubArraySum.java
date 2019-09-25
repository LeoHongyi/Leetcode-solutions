package algorithms.dynamicProgramming;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/97
 * Assumption: array != null && length >= 1
 *  Method: DP, from left to right
 *  dp[i] the largest sum ending at index i
 *  dp[i] = array[i]  if dp[i - 1] <= 0
 *  = dp[i - 1] + array[i]  else
 *  time: O(n), space: O(1)
 */
public class LargestSubArraySum {
    public int largestSum(int[] array) {
        // Write your solution here
        // initialize as 1st element
        int curMax = array[0];
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            // case 1, 2
            curMax = Math.max(array[i], curMax + array[i]);
            // update global max
            result = Math.max(result, curMax);
        }
        return result;
    }
}
