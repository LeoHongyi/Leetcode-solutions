package BinarySearch;

public class SearchInSortedMatrixII {

    public int[] search(int[][] matrix, int target) {
        // Write your solution here
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[] {-1, -1};
        }
        int row = matrix.length, col = matrix[0].length;
        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            if (matrix[i][j] == target) {
                return new int[] {i, j};
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{-1, -1};
    }
}
