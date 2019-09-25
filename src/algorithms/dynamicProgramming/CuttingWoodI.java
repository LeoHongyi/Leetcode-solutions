package algorithms.dynamicProgramming;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/137
 * Method: DP, left breakable, right breakable
 *  A[i] represents the position of the ith marker.
 *  dp[i][j] represents the minimum total cost of cutting the
 *  wood piece between i-th marker and j-th marker.
 *  Base case: (size = 1) The shortest wood piece that cannot be cut any further.
 *  dp[i][i + 1] = 0
 *  dp[0][1] = 0,
 *  dp[1][2] = 0,
 *  dp[2][3] = 0,
 *  ...
 *  dp[i-1][i] = 0,
 *  Induction rule:
 *  dp[i][j] =
 *  First cut position at kth marker(i < k < j)
 *  MIN(A[j] - A[i] + dp[i][k] + dp[k][j])
 *  size = 2, wood piece that's composed of 2 units.
 *  dp[0][2] = A[2] - A[0] + M[0][1] + M[1][2] = 4 + 0 + 0 = 4
 *  dp[1][3] = A[3] - A[1] + M[1][2] + M[2][3] = 5
 *  dp[2][4] = A[4] - A[2] + M[2][3] + M[3][4] = 6
 *  size = 3, wood piece that's composed of 3 consecutive units.
 *  dp[0][3] =
 *  case 1: A[3] - A[0] + M[0][1] + M[1][3] = 7 + 0 + 5 = 12
 *  case 2: A[3] - A[0] + M[0][2] + M[2][3] = 7 + 4 + 0 = 11
 *  MIN(case1, case2) = 11
 *  dp[1][4] =
 *  case 1: A[4] - A[1] + M[1][2] + M[2][4]
 *  case 2: A[4] - A[1] + M[1][3] + M[3][4]
 *  MIN(case1, case2)
 *  size = 4, wood piece that's composed of 4 consecutive units.
 *  dp[0][4] =
 *  case 1: cut A[1]
 *  case 2: cut A[2]
 *  case 3: cut A[3]
 */
public class CuttingWoodI {
    public int minCost(int[] cuts, int length) {
        // Write your solution here
        int n = cuts.length;
        // int[] cutsHelper helps with the whole wood including head and end
        int[] cutsHelper = new int[n + 2];
        cutsHelper[0] = 0;
        for (int i = 0; i < n; i++) {
            cutsHelper[i + 1] = cuts[i];
        }
        cutsHelper[cutsHelper.length - 1] = length;
        int[][] minCost = new int[n + 2][n + 2];
        // base case
        for (int i = 0; i <= n; i++) {
            minCost[i][i + 1] = 0;
        }
        // induction rule,
        // because the data dependency is from bottom to top, from left to right
        // fill the blocks from bottom to top, from left to right
        for (int i = n; i >= 0; i--) {
            for (int j = i + 2; j < cutsHelper.length; j++) {
                int tempCost = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    tempCost = Math.min(tempCost, minCost[i][k] + minCost[k][j]);
                }
                minCost[i][j] = cutsHelper[j] - cutsHelper[i] + tempCost;
            }
        }
        return minCost[0][cutsHelper.length - 1];
    }
}
