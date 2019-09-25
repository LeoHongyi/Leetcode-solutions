package algorithms.sort;

public class MoveZeroII {
	public int[] moveZeroII(int[] array) {
		// Write your solution here
		if(array.length <= 1){
			return array;
		}
		int m = array.length;
		int[] helper = new int[m];
		for (int i = 0; i < m - 1; i++) {
			helper[i] = array[i];
		}
		mergeSortII(array, helper, 0, m - 1);
		return array;
	}

	private void mergeSortII(int[] array, int[] helper, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergeSortII(array, helper, left, mid);
		mergeSortII(array, helper, mid + 1, right);
		merge(array, helper, left, mid, right);
	}

	private void merge(int[] array, int[] helper, int left, int mid, int right) {
		int leftIndex = left, rightIndex = mid + 1;
		while (leftIndex <= mid && rightIndex <= right) {
			if (helper[leftIndex] != 0) {
				array[left++] = helper[leftIndex++];
			} else if (helper[rightIndex] != 0) {
				array[left++] = helper[rightIndex++];
			} else {
				leftIndex++;
				rightIndex++;
			}
		}
		while (leftIndex <= mid) {
			array[left++] = helper[leftIndex++];
		}
	}
}