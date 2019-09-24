package algorithms.array;

public class Move0sToTheEndII {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/530
     */
    public int[] moveZero(int[] array) {
        // Write your solution here
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
