package algorithms.sort;

/**
 * @author Qihao He
 * @date 09/22/2019
 * https://app.laicode.io/app/problem/340
 * Method: insertion sort
 * time: O(n^2), space: O(1)
 */
public class LastOccurrence {
	public static int lastOccur(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		int mid;
		while (left < right - 1){
			mid = left + (right - left)/ 2;
			if (array[mid] == target) {
				left = mid;
			} else if (array[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		if (array[right] == target) {
			return right;
		}else if (array[left] == target) {
			return left;
		} else {
			return -1;
		}
	}
}
