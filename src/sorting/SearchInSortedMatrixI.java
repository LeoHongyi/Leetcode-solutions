package sorting;

public class SearchInSortedMatrixI {
	public static int[] search(int[][] matrix, int target) {
		// Write your solution here
		if (matrix.length == 0 || matrix[0].length == 0) {
			return new int[] {-1, -1};
		}
		int rowNum = matrix.length;
		int colNum = matrix[0].length;
		int left = 0;
		int right = rowNum * colNum - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int r = mid / colNum;
			int c = mid % colNum;
			if (matrix[r][c] == target) {
				return new int[] {r, c};
			} else if (matrix[r][c] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return new int[] {-1, -1};
	}
}
