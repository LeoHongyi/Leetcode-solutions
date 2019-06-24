package sorting;

public class RainbowSortII {
	public static int[] rainbowSortII(int[] array) {
		// Write your solution here
		if (array.length <= 1) {
			return array;
		}
		int i = 0, j = 0, k = 0, l = array.length - 1;
		while (k <= l && j <= l && i <= l) {
			if (array[k] == 0) {
				swap(array, j, k++);
				swap(array, i++, j++);
			} else if (array[k] == 1) {
				swap(array, j++, k++);
			} else if (array[k] == 2) {
				k++;
			} else {
				swap(array, k, l--);
			}
		}
		return array;
	}
	private static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	// 方法2  相向走
	public int[] rainbowSortIITwoPointerInward(int[] array) {
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