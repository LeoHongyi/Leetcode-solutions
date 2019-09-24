package algorithms.dynamicProgramming;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/106
 */
public class LargestSubMatrixSum {
    public int largest(int[][] matrix) {
        // Write your solution here
        int n = matrix.length;
        int m = matrix[0].length;
        int result = Integer.MIN_VALUE;
        // top row
        for (int i = 0; i < n; i++) {
            int[] curRow = new int[m];
            for (int j = i; j < n; j++) {
                // add the matrix[j] row to the curRow for flattening
                add(curRow, matrix[j]);
                // find the max of the curRow and update the result
                result = Math.max(result, max(curRow));
            }
        }
        return result;
    }
    private void add(int[] curRow, int[] matrixRow) {
        for (int i = 0; i < curRow.length; i++) {
            curRow[i] += matrixRow[i];
        }
    }
    private int max(int[] array) {
        int result = array[0];
        int curMax = array[0];
        for (int i = 1; i < array.length; i++) {
            curMax = Math.max(array[i] + curMax, array[i]);
            result = Math.max(curMax, result);
        }
        return result;
    }
}
