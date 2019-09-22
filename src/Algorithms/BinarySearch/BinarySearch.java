package Algorithms.BinarySearch;
//https://app.laicode.io/app/problem/14
public class BinarySearch {
	public int binarySearch(int[] array, int target) {
		// Write your solution here
		if (array == null || array.length == 0){
			return -1;
		}
		int left = 0, right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
