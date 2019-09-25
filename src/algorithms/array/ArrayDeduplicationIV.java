package algorithms.array;

import java.util.Arrays;

public class ArrayDeduplicationIV {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/118
 * Assumption: the given array is not null.
 *  Method: 2 pointers
 *  [0,s) result
 */
    public int[] dedup(int[] array) {
        // Write your solution here
        if (array.length <= 1) {
            return array;
        }
        int fast = 0;
        int slow = 0;
        while (fast < array.length) {
            if (slow == 0 || array[fast] != array[slow - 1]) {
                array[slow] = array[fast];
                slow++;
                fast++;
            } else {
                while (fast < array.length && array[fast] == array[slow - 1]) {
                    fast++;
                }
                slow--;
            }
        }
        return Arrays.copyOf(array, slow);
    }
}
