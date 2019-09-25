package algorithms.binarySearch;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/69
 */
public class MissingNumberII {
    public int missing(int[] array) {
        // Write your solution here
        int i = 1;
        for (; i < array.length + 1; i++) {
            if (i != array[i - 1]) {
                return i;
            }
        }
        return i;
    }

    public int binarySearchMissing(int[] array) {
        int left = 0;
        int right = array.length - 1;
        if (array.length == 0) {
            return 1;
        }
        if (array[right] == right + 1) {
            return array[right] + 1;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= mid + 1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return array[left] - 1;
    }
}