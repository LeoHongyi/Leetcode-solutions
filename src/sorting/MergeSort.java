package sorting;
/**
 * https://app.laicode.io/app/problem/9
 */
public class MergeSort {
	public int[] mergeSort(int[] array) {
		if (array == null || array.length == 0 || array.length == 1){
			//corner case
			return array;
		}
		// allocate helper array to help merge step
		int[] helper = new int[array.length];
		mergeSort(array, helper, 0, array.length - 1);
		return array;
	}

	private void mergeSort(int[] array, int[] helper, int left, int right){
		// array split in half the size arrays
		if (left >= right){
			return;
		}
		int mid = left + (right - left) / 2;
		mergeSort(array, helper, left, mid);
		mergeSort(array, helper, mid + 1, right);
		merge(array, helper, left, mid, right);
	}

	private void merge(int[] array, int[] helper, int left, int mid, int right){
		// merge split arrays
		for (int i = left; i <= right; i++){
			helper[i] = array[i];
		}
		int leftIndex = left;
		int rightIndex = mid + 1;
		while (leftIndex <= mid && rightIndex <= right){
			if(helper[leftIndex] <= helper[rightIndex]){
				array[left++] = helper[leftIndex++];
			}else{
				array[left++] = helper[rightIndex++];
			}
		}
		while (leftIndex <= mid){
			// if we still have some elements at left side, we need to copy them
			array[left++] = helper[leftIndex++];
		}
	}


}

