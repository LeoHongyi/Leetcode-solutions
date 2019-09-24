package algorithms.string;

public class RemoveAdjacentRepeatedCharactersIV {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/82
 * j = 0; (fast) the letter being processed. In other words, all letters to the left of j (not including j) are processed letters.
 *  i = 0; (slow) the letters to be return (not including i).
 */
    public String deDup(String input) {
        // Write your solution here
        if (input == null || input.length() <= 1) {
            return input;
        }
        //try to convert the string to char[], and do it in-place
        char[] array = input.toCharArray();
        // instead of using a extra stack explicitly, we can actually reuse the left side of the original char[] as the "stack".
        // end: where the top of the stack is.
        int end = 0;
        for (int fast = 1; fast < array.length; fast++) {
            if (end == -1 || array[fast] != array[end]) {
                array[++end] = array[fast];
            } else {
                // otherwise, we need pop the top element by end--,
                // and ignore all the consecutive duplicate chars
                end--;
                while (fast + 1 < array.length && array[fast] == array[fast + 1]) {
                    fast++;
                }
            }
        }
        return new String(array, 0, end + 1);
    }
}
