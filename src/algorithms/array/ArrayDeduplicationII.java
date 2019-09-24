package algorithms.array;

import java.util.Arrays;

public class ArrayDeduplicationII {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/116
 * Assumption: the array is not null.
 *  Method: 2 pointers.
 *  [0,s) is the result, [0,f) is the processed
 *  a[s-2] ? a[f]
 */
    public int[] dedup(int[] array) {
        // Write your solution here
        if (array.length <= 2) {
            return array;
        }
        int slow = 2;
        for (int fast = 2; fast < array.length; fast++) {
            if (array[fast] != array[slow - 2]) {
                array[slow] = array[fast];
                slow++;
            }
        }
        return Arrays.copyOf(array, slow);
    }
}
