package algorithms.sort;

public class RainbowSortIII {
	/**
	 * @author: Qihao He
	 * @date: 09/23/2019
	 * https://app.laicode.io/app/problem/400
	 * Method: 2 pointers, move at the same directions to the right
	 *           s     f
	 *0000 1111  23232 xxxxxxx
	 * worst: time: O(kn), space: O(1)
	 * average: time O(2n), space O(1)
	 */
	public int[] rainbowSortIII(int[] array, int k) {

		if (array.length <= 1) {
			return array;
		}
		int slow = 0;
		int target = 1;
		while (slow < array.length && target <= k) {
			int fast = slow;
			while (fast < array.length) {
				if (array[fast] == target) {
					swap(array, slow, fast);
					slow++;
					fast++;
				} else {
					fast++;
				}
			}
			target++;
		}
		return array;
	}
	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}
