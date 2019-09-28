package algorithms.dynamicProgramming;

public class LargestSubArrarySum {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/489
     * Method: DP from left to right linear scan.
     *  curMax[i] represent the max subArray sum inluding the array[i]
     *  curMax[0] = array[0]
     *  curMax[i] = max(array[i], curMax[i - 1] + array[i])
     *  curMax[i] = array[i]    if curMax[i - 1] < 0
     *  =  curMax[i - 1] + array[i]    if curMax[i - 1] >= 0
     *  update gloMax when curMax > gloMax
     *  time O(n), space O(1)
     */
    public int[] largestSumIndex(int[] array) {
        // Write your solution here
        if (array.length == 1) {
            return new int[]{array[0], 0, 0};
        }
        int n = array.length;
        int curStart = 0;
        int gloStart = 0;
        int gloEnd = 0;
        int curMax = array[0];
        int gloMax = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] < curMax + array[i]) {
                curMax = curMax + array[i];
            } else {
                // array[i] >= curMax + array[i]
                curMax = array[i];
                curStart = i;
            }
            if (curMax > gloMax) {
                gloMax = curMax;
                gloStart = curStart;
                gloEnd = i;
            }
        }
        return new int[]{gloMax, gloStart, gloEnd};
    }

    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/97
     * https://leetcode.com/problems/maximum-subarray/
     * Assumption: array != null && length >= 1
     *  Method: DP, linear scan from left to right,
     *  and look back to the previous ones
     *  dp[i] represents the largest sum ending at index i, including i.
     *  dp[i] = array[i]  if dp[i - 1] <= 0
     *       = dp[i - 1] + array[i]  else
     *  time: O(n), space: O(1)
     */
    public class LargestSubArraySum {
        public int largestSum(int[] array) {
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

}
