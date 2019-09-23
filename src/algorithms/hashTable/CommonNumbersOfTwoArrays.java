package algorithms.hashTable;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

/**
 Method 1: HashSet
 Step 1: insert all smaller[] numbers into a hashSet, O(n) on average, o(n^2) in worst case
 Step 2: Find in bigger[] common elements, O(m) in average, O(m*n) in worst case.
 time: O(n^2 + m*n) worst, O(m + n) average
 space: O(n)
 **/
public class CommonNumbersOfTwoArrays {
	public List<Integer> common(List<Integer> a, List<Integer> b) {
		// Write your solution here
		// the smaller one is a, bigger one is b
		Set<Integer> set = new HashSet<>();
		if (a.size() > b.size()) {
			common(b, a);
		}
		// put smaller[] into a HashSet
		for (int ele : a) {
			set.add(ele);
		}
		List<Integer> result = new ArrayList<>();
		for (int ele : b) {
			if (set.contains(ele)) {
				result.add(ele);
			}
		}
		// sort result
		result = sort(result);
		return result;
	}
	// quick sort the input
	private List<Integer> sort(List<Integer> input) {
		if (input == null || input.size() <= 1) {
			return input;
		}
		int n = input.size();
		int[] array = new int[n];
		int i = 0;
		for (Integer ele : input) {
			array[i++] = ele;
		}
		quickSort(array, 0, array.length - 1);
		List<Integer> result = new ArrayList<>();
		for (int j = 0; j < array.length; j++) {
			result.add(array[j]);
		}
		return result;
	}
	private void quickSort(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}
		// process at current level
		int pivotPos = partition(array, start, end);
		// process the left, right part
		quickSort(array, start, pivotPos - 1);
		quickSort(array, pivotPos + 1, end);
	}
	private int partition(int[] array, int start, int end) {
		// save pivotIndex and pivotValue
		int pivotIndex = pivotIndex(start, end);
		int pivotValue = array[pivotIndex];
		swap(array, pivotIndex, end);
		int left = start;
		int right = end - 1;
		while (left <= right) {
			if (array[left] <= pivotValue) {
				left++;
			} else if (array[right] >= pivotValue) {
				right--;
			} else {
				swap(array, left++, right--);
			}
		}
		// the left is pointing at the first a[i] >= pivotValue
		swap(array, left, end);
		// return the current position of the pivotValue
		return left;
	}
	private int pivotIndex(int left, int right) {
		return (int)Math.random() * (right - left + 1) + left;
	}
	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}
