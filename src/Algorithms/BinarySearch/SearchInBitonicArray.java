package Algorithms.BinarySearch;
//https://app.laicode.io/app/problem/401
public class SearchInBitonicArray {
    public int search(int[] array, int target) {
        if (array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < array[mid + 1]) {
                left = mid;
            } else if (array[mid] > array[mid + 1]) {
                right = mid;
            }
        }
        int maxIndex = array[left] > array[right] ? left : right;
        return Math.max(binarySearch(array, target, 0, maxIndex, true),
                binarySearch(array, target, maxIndex + 1, array.length - 1, false));
    }
    private int binarySearch(int[] array, int target, int left, int right, boolean increasing) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                if (increasing) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (increasing) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}