package sorting;

public class RainbowSort {
	/**
	 * @author Qihao He
	 * @date 09/21/2019
	 * https://app.laicode.io/app/problem/11
	 * Method: rainbow sort, 3 pointers
	 * time: O(n)
	 * space: O(1)
	 */
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

	/**
	 * @author Qihao He
	 * @date 09/21/2019
	 * https://app.laicode.io/app/problem/11
	 * Method: rainbow sort, slow, fast pointers
	 * time: worst case: O(n^2)
	 * space: O(1)
	 */
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
