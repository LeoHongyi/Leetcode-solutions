package algorithms.dynamicProgramming;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/101
 * Assumption: matrix is not null, size = N*N, N >= 0
 *  Method: DP
 *  dp[i][j] represent the largest square of 1 with dp[i][j] at right bottom, at matrix[i][j]
 *  dp[i][j] = iff matrix[i][j] = 1, dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
 *  =0  else
 *  global max record the largest square
 */
public class LargestSquareOf1s {
    public int largest(int[][] matrix) {
        // Write your solution here
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int result = 0;
        int[][] largestSquare = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    // 1st row, 1st col, just fill the matrix[i][j] 1 or 0.
                    largestSquare[i][j] = matrix[i][j] == 1 ? 1 : 0;
                } else if (matrix[i][j] == 1) {
                    // pick the min from the left, top, leftTop corner + 1
                    largestSquare[i][j] = Math.min(largestSquare[i - 1][j] + 1, largestSquare[i][j - 1] + 1);
                    largestSquare[i][j] = Math.min(largestSquare[i - 1][j - 1] + 1, largestSquare[i][j]);
                }
                // update global max
                result = Math.max(result, largestSquare[i][j]);
            }
        }
        return result;
    }
}
