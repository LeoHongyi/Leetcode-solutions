package algorithms.array;

import java.util.Arrays;

public class ArrayDeduplicationIII {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/117
 * Method: 2 pointers
 */
    public int[] dedup(int[] array) {
        // Write your solution here
        if (array.length <= 1) {
            return array;
        }
        int slow = 0;
        // use flag to see if there is any duplicates of array[end]
        boolean flag = false;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] == array[slow]) {
                // a[fast] == a[slow], set flag
                flag = true;
            } else if (array[fast] != array[slow] && flag == true) {
                // a[fast] != a[slow], but flag is true
                array[slow] = array[fast];
                flag = false;
            } else {
                // a[fast] != a[slow] && flag == false
                // there is no duplicate of the array[end]
                slow++;
                array[slow] = array[fast];
            }
        }
        return Arrays.copyOf(array, flag ? slow : slow + 1);
    }
}
