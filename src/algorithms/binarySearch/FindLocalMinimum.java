package algorithms.binarySearch;
/**
 *  @author Qihao He
 *  @date 09/24/2019
 * https://app.laicode.io/app/problem/327
 */
public class FindLocalMinimum {
    public int localMinimum(int[] array) {
        if (array.length == 1) {
            return 0;
        }
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midL;
            int midR;
            if (mid == 0) {
                midL = Integer.MAX_VALUE;
            } else {
                midL = array[mid - 1];
            }
            if (mid == array.length - 1) {
                midR = Integer.MAX_VALUE;
            } else {
                midR = array[mid + 1];
            }
            if (midL > array[mid] && midR > array[mid]) {
                return mid;
            } else if (midL > array[mid] && midR < array[mid]) {
                left = mid + 1;
            } else if (midL < array[mid] && midR > array[mid]) {
                right = mid - 1;
            } else {
                right = mid;
                //left = mid || right = mid // both works, no strict limitation
            }
        }
        return -1;
    }
}