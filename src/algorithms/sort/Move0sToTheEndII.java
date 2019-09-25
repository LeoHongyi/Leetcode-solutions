package algorithms.sort;
/**
 * @author: Qihao He
 * @date 06/21/2019
 * https://app.laicode.io/app/problem/259
 * Method: rainbow sort
 * time: O(n)
 * space O(1)
 */
public class Move0sToTheEndII {
    public int[] moveZero(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int slow = 0;
        int fast = 0;
        while (slow < array.length && fast < array.length) {
            if (array[fast] != 0) {
                array[slow] = array[fast];
                slow++;
                fast++;
            } else {
                fast++;
            }
        }
        while (slow < array.length) {
            array[slow] = 0;
            slow++;
        }
        return array;
    }
}
