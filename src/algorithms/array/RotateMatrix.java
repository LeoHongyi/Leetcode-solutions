package algorithms.array;

public class RotateMatrix {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/125
 * Assumption: matrix is not null, size n * n , n >= 0
 *  Method 2: rotate a point by 90 degree clockwise ==
 *  1. mirror the point according to y axis, then
 *  2. mirror the point according the line of y = x.
 */
    public void rotate(int[][] matrix) {
        // Write your solution here
        int n = matrix.length;
        if (n <= 1) {
            return;
        }
        mirrorY(matrix, n);
        mirrorYEX(matrix, n);
    }
    // mirror the point by y axis.
    private void mirrorY(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, n - 1 - j);
            }
        }
    }
    // mirror the point by the line of y = x.
    private void mirrorYEX(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j + i < n - 1; j++) {
                swap(matrix, i, j, n - 1 - j, n - 1 - i);
            }
        }
    }
    private void swap(int[][] matrix, int iRow, int iCol, int jRow, int jCol) {
        int temp = matrix[iRow][iCol];
        matrix[iRow][iCol] = matrix[jRow][jCol];
        matrix[jRow][jCol] = temp;
    }
}
