package algorithms.sort;
/**
 * @author: Qihao He
 * @date: 09/23/2019
 * https://app.laicode.io/app/problem/399
 * Method 1: 4 pointers, 2 at left, 2 at right, move towards center
 * time: O(n)
 * space: O(1)
 *      i     j   k    l
 * 0000 1111  xxxxx 2222 33333
 * Method 2: 2 pointers, move at the same directions to the right
 *           s     f
 *0000 1111  23232 xxxxxxx
 * time: O(n)
 * space: O(1)
 */
public class RainbowSortII {

	public int[] rainbowSortII(int[] array) {
		// Write your solution here
		if (array.length <= 1) {
			return array;
		}
		int slow = 0;
		int target = 0;
		while (slow < array.length && target <= 3) {
			int fast = slow;
			while (fast < array.length) {
				if (array[fast] == target) {
					swap(array, fast, slow);
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

	public int[] rainbowSortIITwoPointerInward(int[] array) {
		// method 3: 2 pointers move at the opposite direction
		if (array == null || array.length <= 1) {
			return array;
		}
		int left = 0;
		int right = array.length-1;
		for (int target = 0; target < 3; target++) {
			while(left < right) {
				while(left < right && array[left] == target) {
					left++;
				}
				while( left < right && array[right] != target) {
					right -- ;
				}
				if (left == right) {
					break;
				}
				swap(array, left++, right--);
			}
			left = array[left] == target ? left + 1 : left;
			right = array.length-1;
			if(left == array.length) {
				break;
			}
		}
		return array;
	}
}