package algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseI {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/121
     */
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        DFS(matrix, result, 0, matrix.length);
        return result;
    }
    private void DFS(int[][] matrix, List<Integer> result, int offset, int size) {
        // when the last matrix size is 2
        if (size == 0) {
            return;
        }
        // when the last matrix size is 1
        if (size == 1) {
            result.add(matrix[offset][offset]);
            return;
        }
        for (int i = offset; i < offset + size - 1; i++) {
            result.add(matrix[offset][i]);
        }
        for (int i = offset; i < offset + size - 1; i++) {
            result.add(matrix[i][offset + size - 1]);
        }
        for (int i = offset + size - 1; i > offset; i--) {
            result.add(matrix[offset + size - 1][i]);
        }
        for (int i = offset + size - 1; i > offset; i--) {
            result.add(matrix[i][offset]);
        }
        DFS(matrix, result, offset + 1, size - 2);
    }
}
