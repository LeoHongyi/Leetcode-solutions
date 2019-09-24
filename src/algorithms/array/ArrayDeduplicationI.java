package algorithms.array;

import java.util.Arrays;

public class ArrayDeduplicationI {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/115
 *  Assumption: array is not null
 *  Method: 2 pointers
 */
    public int[] dedup(int[] array) {
        // Write your solution here
        if (array.length <= 1) {
            return array;
        }
        int slow = 1;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] != array[slow - 1]) {
                array[slow] = array[fast];
                slow++;
            }
        }
        //copyOf(int[] original, int newLength)
        return Arrays.copyOf(array, slow);
    }
}
