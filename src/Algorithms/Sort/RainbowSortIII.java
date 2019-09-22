package Algorithms.Sort;

public class RainbowSortIII {
	public static int[] rainbowSortIII(int[] array, int k) {
		// Write your solution here
		if (array.length <= 1) {
			return array;
		}
		// 1111111  234567  xxxxxxxxxx
		//[0     i)[i    j)[j     n-1]
		int n = array.length, i = 0, j = 0;
		for (int key = 1; key <= k; key++) {
			while(j <= n - 1) {
				if (array[j] == key) {
					int temp = array[i];
					array[i++] = array[j];
					array[j++] = temp;
				} else {
					j++;
				}
			}
			j = i;
		}
		return array;
	}
}

