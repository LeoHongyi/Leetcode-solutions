package algorithms.dynamicProgramming;

public class EditDistance {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/100
 * Assumption: both strings are not null
 *  Method: DP 2D
 *  dp[i][j] represent the minimum edit distance between the one[0, i] and two[0, j]
 *  dp[i][j] = dp[i - 1][j - 1]  when one[i] == two[j]
 *  = Min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1, else
 */
    public int editDistance(String one, String two) {
        // Write your solution here
        int rows = one.length();
        int cols = two.length();
        int[][] editDistance = new int[rows + 1][cols + 1];
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < cols + 1; j++) {
                if (i == 0) {
                    editDistance[i][j] = j;
                } else if (j == 0) {
                    editDistance[i][j] = i;
                    // string and editDistance[][] has one index offset
                } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    editDistance[i][j] = editDistance[i - 1][j - 1];
                } else {
                    editDistance[i][j] = Math.min(editDistance[i - 1][j] + 1, editDistance[i][j - 1] + 1);
                    editDistance[i][j] = Math.min(editDistance[i - 1][j - 1] + 1, editDistance[i][j]);
                }
            }
        }
        return editDistance[rows][cols];
    }
}
