package Algorithms.Sort;
public class QuickSort {
	/**
	 * @author Qihao He
	 * @date 09/21/2019
	 * https://app.laicode.io/app/problem/10
	 * Method: quick sort
	 * worst case: time: O(n^2), space: stack: O(n)
	 * average case: time: O(nlogn), space: number of levels logn, O(logn)
	 */
	public int[] quickSort(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		quickSort(array, 0, array.length - 1);
		return array;
	}
	private void quickSort(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}
		int pivotIndex = partition(array, start, end);
		quickSort(array, start, pivotIndex - 1);
		quickSort(array, pivotIndex + 1, end);
		return;
	}
	private int partition(int[] array, int start, int end) {
		int pivotIndex = start + (int)Math.random() * (end - start + 1);
		int pivotValue = array[pivotIndex];
		swap(array, pivotIndex, end);
		int left = start;
		int right = end - 1;
		while (left <= right) {
			if (array[left] < pivotValue) {
				left++;
			} else if (array[right] > pivotValue) {
				right--;
			} else {
				swap(array, left, right);
				left++;
				right--;
			}
		}
		swap(array, left, end);
		return left;
	}
	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
		return;
	}
}

