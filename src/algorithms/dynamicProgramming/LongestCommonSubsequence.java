package algorithms.dynamicProgramming;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/177
 * Method: DP2, linear scan and look back the previous values
 *  dp[i][j] represent the longest common subsequence between the first i letters of A
 *  and the first j letters of B
 *  Base case:
 *  dp[0][0] = 0,
 *  dp[i][0] = 0,
 *  dp[0][j] = 0,
 *  dp[i][j] = dp[i - 1][j - 1] + 1, if A[i - 1] == B[j - 1]
 *  = max(dp[i - 1][j], dp[i][j - 1]), if A[i - 1] != B[j - 1]
 */
public class LongestCommonSubsequence {
    public int longest(String source, String target) {
        // Write your solution here
        int sLength = source.length();
        int tLength = target.length();
        int[][] commonSequence = new int[sLength + 1][tLength + 1];
        // base case covered in initialization
        for (int i = 1; i < sLength + 1; i++) {
            for (int j = 1; j < tLength + 1; j++) {
                if (source.charAt(i - 1) == target.charAt(j - 1)) {
                    // case 1: if the same char
                    commonSequence[i][j] = commonSequence[i - 1][j - 1] + 1;
                } else {
                    // case 2: not the same char
                    commonSequence[i][j] = Math.max(commonSequence[i - 1][j], commonSequence[i][j - 1]);
                }
            }
        }
        return commonSequence[sLength][tLength];
    }
}
