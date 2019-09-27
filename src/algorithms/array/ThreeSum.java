package algorithms.array;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/186
 * https://leetcode.com/problems/3sum/
 * Assumption:
 * 1. nums maybe null or any length
 * 2. duplicate elements
 * No duplicate triples should be returned, order of the values in the tuple does not matter.
 * Method: sort array, 3 pointers.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // sanity check
        if (array == null || array.length < 3) {
            return result;
        }
        Arrays.sort(array);
        int len = array.length;
        // maintain i < j < k
        for (int i = 0; i < len - 2; i++) {
            // start <= i < left < right <= end
            if (i > 0 && array[i] == array[i - 1]) {
                // skip duplicate elements
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int temp = array[i] + array[left] + array[right];
                if (temp == target) {
                    result.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;
                    while (left < right && array[left] == array[left - 1]) {
                        // skip duplicate elements
                        left++;
                    }
                } else if (temp < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
