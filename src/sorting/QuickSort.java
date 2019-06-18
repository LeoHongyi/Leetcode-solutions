package sorting;
public class QuickSort {
	public int[] quickSort(int[] array) {
		// Write your solution here
		if(array == null || array.length == 0){
			return array;
		}
		quickSort(array, 0, array.length - 1);
		return array;
	}

	private static void quickSort(int[] array, int left, int right){
		if(left >= right){
			return;
		}
		int pivotPos = partition(array, left, right);
		quickSort(array, left, pivotPos - 1);
		quickSort(array, pivotPos + 1, right);
	}

	private static int partition(int[] array, int left, int right){
		int pivotIndex = pivotIndex(left, right);
		int pivotValue = array[pivotIndex];
		swap(array, pivotIndex, right);
		int leftBound = left;
		int rightBound = right - 1;
		while(leftBound <= rightBound){
			if(array[leftBound] <= pivotValue){
				leftBound++;
			}else if(array[rightBound] >= pivotValue){
				rightBound--;
			}else{
				swap(array, leftBound++, rightBound--);
			}
		}
		swap(array, leftBound, right);
		return leftBound;
	}

	private static int pivotIndex(int left, int right){
		return (int)Math.random()*(right - left + 1) + left;
	}

	private static void swap(int[] array, int left, int right){
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}
