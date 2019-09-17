package BinarySearch;

public class SearchInShiftedSortedArrayII {
    public int search(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] > array[right]) {
                if (array[left] <= target && target < array[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (array[mid] < array[right]) {
                if (array[mid] < target && target <= array[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                right--;
            }
        }
        // exit with one element point by index left
        if (array[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
}
