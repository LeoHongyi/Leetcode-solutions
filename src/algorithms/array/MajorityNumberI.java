package algorithms.array;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/206
 * For more than 1 / k occurs of the whole input,
 *  the stage should have k - 1 standing.
 *  Assumption: array is not null and is not empty.
 *  majority number guarantees to exit.
 */
public class MajorityNumberI {
    public int majority(int[] array) {
        // Write your solution here
        int candidate = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                count++;
                candidate = array[i];
            } else if (candidate == array[i]) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}