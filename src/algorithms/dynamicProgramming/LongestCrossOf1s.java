package algorithms.dynamicProgramming;

public class LongestCrossOf1s {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/104
 * Assumption: matrix is not null, has size of N * M
 *  Method: DP, 2d, preprocess the matrix from left, up, right down
 *  time: O(n*m*3) space: O(n*m*4)
 */
    public int largest(int[][] matrix) {
        // Write your solution here
        int n = matrix.length;
        int m = matrix[0].length;
        if (n == 0 || m == 0) {
            return 0;
        }
        // leftUp matrix for longest possible length
        int[][] leftUp = leftUp(matrix, n, m);
        int[][] rightDown = rightDown(matrix, n, m);
        return merge(leftUp, rightDown, n, m);
    }
    private int merge(int[][] leftUp, int[][] rightDown, int n, int m) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // find the min from two matrix, and store in leftUp matrix
                leftUp[i][j] = Math.min(leftUp[i][j], rightDown[i][j]);
                // update the global max
                result = Math.max(result, leftUp[i][j]);
            }
        }
        return result;
    }
    private int[][] leftUp(int[][] matrix, int n, int m) {
        int[][] left = new int[n][m];
        int[][] up = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 && j == 0) {
                        left[i][j] = 1;
                        up[i][j] = 1;
                    } else if (i == 0) {
                        up[i][j] = 1;
                        left[i][j] = left[i][j - 1] + 1;
                    } else if (j == 0) {
                        left[i][j] = 1;
                        up[i][j] = up[i - 1][j] + 1;
                    } else {
                        up[i][j] = up[i - 1][j] + 1;
                        left[i][j] = left[i][j - 1] + 1;
                    }
                }
            }
        }
        merge(left, up, n, m);
        return left;
    }
    private int[][] rightDown(int[][] matrix, int n, int m) {
        int[][] right = new int[n][m];
        int[][] down = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (i == n - 1 && j == m - 1) {
                        right[i][j] = 1;
                        down[i][j] = 1;
                    } else if (i == n - 1) {
                        down[i][j] = 1;
                        right[i][j] = right[i][j + 1] + 1;
                    } else if (j == m - 1) {
                        right[i][j] = 1;
                        down[i][j] = down[i + 1][j] + 1;
                    } else {
                        down[i][j] = down[i + 1][j] + 1;
                        right[i][j] = right[i][j + 1] + 1;
                    }
                }
            }
        }
        merge(right, down, n, m);
        return right;
    }
}
