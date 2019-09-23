package algorithms.binarySearch;
//https://app.laicode.io/app/problem/23
public class ShiftPosition {
    public int shiftPosition(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] > array[left] && array[mid] > array[right]) {
                left = mid;
            } else if (array[mid] < array[left] && array[mid] < array[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        if (array[left] > array[right]) {
            return left + 1;
        } else {
            return 0;
        }
    }
}
