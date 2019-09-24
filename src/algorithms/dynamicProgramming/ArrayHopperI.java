package algorithms.dynamicProgramming;

public class ArrayHopperI {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/530
 *  Method: DP, from right to left, and return the left most result
 *  dp[i] represent the index i can jump to the end
 *  dp[0] = true
 *  dp[i] = true, if i + array[i] > length - 1 or iff dp[j]=true and i<j<array[i]
 *  = false, else
 *  time: O(n^2), space O(n)
 */
    public boolean canJump(int[] array) {
        // Write your solution here
        if (array.length == 1) {
            return true;
        }
        int length = array.length;
        boolean[] dp = new boolean[length];
        dp[length - 1] = true;
        for (int i = length - 2; i >= 0; i--) {
            if (array[i] + i >= length - 1) {
                dp[i] = true;
            } else {
                for (int j = i + array[i]; j >= 1; j--) {
                    if (dp[j] == true) {
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[0];
    }
}
