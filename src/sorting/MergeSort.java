package sorting;

public class MergeSort {

	public static int[] mergeSort(int[] array) {
		// Write your solution here
		if (array == null || array.length == 0 || array.length == 1){
			return array;//corner case
		}
		//allocate helper array to help merge step
		int[] helper = new int[array.length];
		mergeSort(array, helper, 0, array.length - 1);
		return array;
	}
	//array split in half the size arrays
	private void mergeSort(int[] array, int[] helper, int left, int right){
		if (left >= right){
			return;
		}
		int mid = left + (right - left) / 2;
		mergeSort(array, helper, left, mid);
		mergeSort(array, helper, mid + 1, right);
		merge(array, helper, left, mid, right);
	}
	//merge splited arrays
	public void merge(int[] array, int[] helper, int left, int mid, int right){
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
		//if we still have some elements at left side, we need to copy them
		while (leftIndex <= mid){
			array[left++] = helper[leftIndex++];
		}
	}
}

