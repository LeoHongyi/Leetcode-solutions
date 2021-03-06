package algorithms.sort;
/**
 * @author Qihao He
 * @date 09/24/2019
 */
public class FirstOccurrence {
	public static int firstOccur(int[] array, int target) {
		// Write your solution here
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				right = mid;
			} else if (array[mid] > target) {
				right = mid;
			} else {
				left = mid;
			}
		}
		if (array[left] == target) {
			return left;
		} else if (array[right] == target) {
			return right;
		} else {
			return -1;
		}
	}
}