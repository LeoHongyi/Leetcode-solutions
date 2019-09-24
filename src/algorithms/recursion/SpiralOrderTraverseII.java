package algorithms.recursion;

public class SpiralOrderTraverseII {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/122
     */
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        spiral(result, matrix, 0, row, col);
        return result;
    }
    private static void spiral(List<Integer> result, int[][] matrix, int offset, int row, int col) {
        if (row == 0 || col == 0) {
            return;
        } else if (row == 1 && col == 1) {
            result.add(matrix[offset][offset]);
            return;
        } else if (row == 1) {
            for (int i = offset; i < offset + col; i++) {
                result.add(matrix[offset][i]);
            }
            return;
        } else if (col == 1) {
            for (int i = offset; i < offset + row; i++) {
                result.add(matrix[i][offset]);
            }
            return;
        }
        for (int i = offset; i < offset + col - 1; i++) {
            result.add(matrix[offset][i]);
        }
        for (int i = offset; i < offset + row - 1; i++) {
            result.add(matrix[i][offset + col - 1]);
        }
        for (int i = offset + col - 1; i > offset; i--) {
            result.add(matrix[offset + row - 1][i]);
        }
        for (int i = offset + row - 1; i > offset; i--) {
            result.add(matrix[i][offset]);
        }
        spiral(result, matrix, offset + 1, row - 2, col - 2);
    }
}
