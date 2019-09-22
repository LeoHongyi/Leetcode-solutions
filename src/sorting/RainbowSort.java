package sorting;

public class RainbowSort {
	public int[] rainbowSort(int[] array) {
		// Write your solution here
		if (array == null || array.length <= 1) {
			return array;
		}
		int i = 0;
		int j = 0;
		int k = array.length - 1;
		while (j <= k) {
			if (array[j] == -1) {
				swap(array, i, j);
				i++;
				j++;
			} else if (array[j] == 1) {
				swap(array, j, k);
				k--;
			} else {
				j++;
			}
		}
		return array;
	}
	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
		return;
	}

	public int[] rainbowSort2(int[] array) {
		// Write your solution here
		if (array.length <= 1) {
			return array;
		}
		int slow = 0, fast = 0;
		for (int key = -1; key < 2; key++) {
			while (fast < array.length - 1) {
				if (array[fast] == key) {
					int temp = array[slow];
					array[slow++] = array[fast];
					array[fast++] = temp;
				} else {
					fast++;
				}
			}
			fast = slow;
		}
		return array;
	}
}
