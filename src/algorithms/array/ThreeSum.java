package algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/186
 * Assumption: the array is not null, length >= 3
 *  No duplicate triples should be returned, order of the values in the tuple does not matter.
 *  Method: sort array, 3 pointers.
 */
public class ThreeSum {
    public List<List<Integer>> allTriples(int[] array, int target) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(array);
        // maintain i < j < k
        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int temp = array[left] + array[right];
                if (temp + array[i] == target) {
                    result.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;
                    while (left < right && array[left] == array[left - 1]) {
                        left++;
                    }
                } else if (temp + array[i] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
