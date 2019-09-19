package BinarySearch;

public class SearchInBitonicArray {
    public int search(int[] array, int target) {
        // Write your solution here
        if (array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < array[mid + 1]) { // mid + 1 at most == right
                left = mid;
            } else if (array[mid] > array[mid + 1]) {
                right = mid;
            }
        }
        int max = array[left] > array[right] ? left : right;
        return Math.max(binarySearch(array, 0, max, target, true),
                binarySearch(array, max, array.length - 1, target, false));
    }

    private int binarySearch(int[] array, int left, int right, int target, boolean increasing) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                if (increasing == true) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (increasing == true) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}