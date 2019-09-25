package algorithms.twoPointers;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/199
 * Method: dp,
 */
public class MaxWaterTrapperI {
    public int maxTrapped(int[] array) {
        // Write your solution here
        if (array.length == 0) {
            return 0;
        }
        int result = 0;
        int left = 0;
        int right = array.length - 1;
        int lMax = array[left];
        int rMax = array[right];
        while (left < right) {
            if (array[left] <= array[right]) {
                result += Math.max(0, lMax - array[left]);
                lMax = Math.max(lMax, array[left]);
                left++;
            } else {
                result += Math.max(0, rMax - array[right]);
                rMax = Math.max(rMax, array[right]);
                right--;
            }
        }
        return result;
    }
}
