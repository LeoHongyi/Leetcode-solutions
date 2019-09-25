package algorithms.dynamicProgramming;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/105
 * Assumption: the given matrix is not null, size n*m, n,m>=0
 *  Method: DP, 2d，preprocess the matrix from
 *  left: from left top, up: from right top,
 *  down: from left down, right: from right down.
 *  dp[i][j] = min(dpLeft[i+1][j-1],dpUp[i-1][j-1],dpRight[i-1][j+1],dpDown[i+1][j+1]) + 1,iff matrix[i][j] == 1
 *  time: O(n*m*3), space: O(n*m*4)
 */
public class LargestXOf1s {
    public int largest(int[][] matrix) {
        // Write your solution here
        int n = matrix.length;
        int m = matrix[0].length;
        if (n == 0 || m == 0) {
            return 0;
        }
        int[][] leftUp = leftUp(matrix, n, m);
        int[][] rightDown = rightDown(matrix, n, m);
        return merge(leftUp, rightDown, n, m);
    }
    private int merge(int[][] leftUp, int[][] rightDown, int n, int m) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // find the min value of the x of 1s
                leftUp[i][j] = Math.min(leftUp[i][j], rightDown[i][j]);
                // update the global max.
                result = Math.max(result, leftUp[i][j]);
            }
        }
        return result;
    }

    private int[][] leftUp(int[][] matrix, int n, int m) {
        // filling the dpUp[][], dpLeft[][] from 0 to n,
        // left: from left top, up: from right top,
        int[][] left = new int[n][m];
        int[][] up = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // only when matrix[i][j] == 1
                if (matrix[i][j] == 1) {
                    left[i][j] = getDP(left, i - 1, j - 1, n, m) + 1;
                    up[i][j] = getDP(up, i - 1, j + 1, n, m) + 1;
                }
            }
        }
        merge(left, up, n, m);
        return left;
    }

    private int[][] rightDown(int[][] matrix, int n, int m) {
        // filling the dpRight[][] dpDown[][] from n - 1 to 0,
        // down: from left down, right: from right down.
        int[][] right = new int[n][m];
        int[][] down = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    right[i][j] = getDP(right, i + 1, j + 1, n, m) + 1;
                    down[i][j] = getDP(down, i + 1, j - 1, n, m) + 1;
                }
            }
        }
        merge(right, down, n, m);
        return right;
    }

    private int getDP(int[][] DP, int x, int y, int n, int m) {
        // return the dpXXXX[i][j] for new dpXXXX[][]
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return 0;
        }
        return DP[x][y];
    }
}
