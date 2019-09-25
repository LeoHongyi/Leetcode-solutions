package algorithms.binarySearch;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/24
 * Method: binary search find the target,
 * find all target if duplicate targets
 */
public class TotalOccurence {
    public int totalOccurrence(int[] array, int target) {
        // Write your solution here
        return binarySearch(array, target);
    }
    private int binarySearch(int[] array, int target) {
        int result = 0;
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        // binary search find the target
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (array[mid] == target) {
                result = 1;
                break;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // not find the target
        if (result == 0) {
            return 0;
        } else {
            // binary search find the possible duplicate targets
            // left side, find first occurance
            left = firstOccurBS(array, 0, mid, target);
            // right side, find last occurance
            right = lastOccurBS(array, mid, array.length - 1, target);
            return right - left + 1;
        }
    }
    private int firstOccurBS(int[] array, int left, int right, int target) {
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (array[left] == target) {
            return left;
        } else {
            return right;
        }
    }
    private int lastOccurBS(int[] array, int left, int right, int target) {
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (array[right] == target) {
            return right;
        } else {
            return left;
        }
    }
}
