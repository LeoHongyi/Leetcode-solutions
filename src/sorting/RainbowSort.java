package sorting;

public class RainbowSort {
	public static int[] rainbowSort(int[] array) {
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
