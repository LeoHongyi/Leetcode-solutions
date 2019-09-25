package algorithms.dynamicProgramming;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/87
 * Method: DP, left hand side breakable, right hand side breakable
 *  dp[i] represent the maxProduct at length i
 *  dp[0] undefined
 *  dp[1] undefined
 *  dp[2] = 1
 *  dp[i] = Math.max(array[i], j * Math.max(i - j, array[i - j]));
 *  Assumption: length >= 2
 */
public class MaxProductOfCuttingRope {
    public int maxProduct(int length) {
        // Write your solution here
        if (length == 2) {
            return 1;
        }
        int[] array = new int[length + 1];
        array[1] = 0;
        array[2] = 1;
        for (int i = 3; i < array.length; i++) {
            for (int j = 1; j <= i / 2; j++) {
                // update array[i] if possible
                array[i] = Math.max(array[i], j * Math.max(i - j, array[i - j]));
            }
        }
        return array[length];
    }
}
