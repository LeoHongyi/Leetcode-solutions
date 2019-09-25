package algorithms.dynamicProgramming;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/102
 * Method: 2D DP, int[][] right 每行从右往左数，int[][] down 每列从下往上数
 *  time: O(n^3), space O(n^2)
 *  example 1:
 *  right    Row  Col(min)
 *  3 <---   1    3
 *  3 <---   2    3
 *  1 <---   3    1
 *  result = 2 * 3
 *
 *  example 2:
 *  right    Row  Col(min)
 *  3 <---   1    3
 *  2 <---   2    2
 *  2 <---   3    2
 *  result = 3 * 2
 *
 *  Assumption: the matrix is not null, size N * M, N, M >= 0
 */
public class LargestRectangleOf1s {
    public int largest(int[][] matrix) {
        // Write your solution here
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int N = matrix.length;
        int M = matrix[0].length;
        int result = 0;
        int[][] right = right(matrix, N, M);
        int[][] down = down(matrix, N, M);
        return maxRec(right, down, N, M);
    }

    private int maxRec(int[][] right, int[][] down, int N, int M) {
        int result = 0;
        int cur = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (right[i][j] >= 1) {
                    cur = right[i][j];
                    // going down from right[i][j]
                    for (int k = 1; k <= down[i][j]; k++) {
                        cur = Math.min(cur, right[i + k - 1][j]);
                        result = Math.max(result, cur * k);
                    }
                }
            }
        }
        return result;
    }

    private int[][] right(int[][] matrix, int N, int M) {
        // num of 1s from right to left
        int[][] right = new int[N][M];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (j == M - 1) {
                        right[i][j] = 1;
                    } else {
                        right[i][j] = right[i][j + 1] + 1;
                    }
                }
            }
        }
        return right;
    }

    private int[][] down(int[][] matrix, int N, int M) {
        // num of 1s from down to up
        int[][] down = new int[N][M];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (i == N - 1) {
                        down[i][j] = 1;
                    } else {
                        down[i][j] = down[i + 1][j] + 1;
                    }
                }
            }
        }
        return down;
    }
}
