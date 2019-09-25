package algorithms.binarySearch;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/268
 */
public class SearchInSortedMatrixII {
    public int[] search(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[] {-1, -1};
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rowsIndex = 0;
        int colsIndex = cols - 1;
        while (rowsIndex < rows && colsIndex >= 0) {
            if (matrix[rowsIndex][colsIndex] == target) {
                return new int[] {rowsIndex, colsIndex};
            } else if (matrix[rowsIndex][colsIndex] > target) {
                colsIndex--;
            } else {
                rowsIndex++;
            }
        }
        return new int[] {-1, -1};
    }
}
