package algorithms.dynamicProgramming;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/103
 * Assumption: the given array is not null
 *  Method: DP, left to right
 *  dp[i] represent the longest consecutive of 1s ending at i, must including i.
 *  dp[0] = array[0]
 *  dp[i] = dp[i - 1] + 1, if array[i] == 1
 *  = 0, else
 *  global max record the max
 *  time: O(n), space: O(1)
 */
public class LongestConsecutiveIs {
    public int longest(int[] array) {
        // Write your solution here
        if (array.length == 0) {
            return 0;
        }
        int curMax = array[0];
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 1) {
                curMax = curMax + 1;
            } else {
                curMax = 0;
            }
            // update the global max
            result = Math.max(result, curMax);
        }
        return result;
    }
}
