package algorithms.binarySearch;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/236
 */
public class SearchInsertPosition {
    public int searchInsert(int[] input, int target) {
        // Write your solution here
        if (input == null || input.length == 0) {
            return 0;
        }
        int left = 0;
        int right = input.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (input[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (input[left] >= target) {
            return 0;
        } else if (input[left] < target && input[right] >= target) {
            return right;
        } else {
            return right + 1;
        }
    }
}
