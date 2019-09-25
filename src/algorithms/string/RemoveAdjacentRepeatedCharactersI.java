package algorithms.string;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/79
 * Assumptions: in place process, given string is null, returning null
 *  or an empty Stirng are both valid.
 *  Method: 2 pointers
 */
public class RemoveAdjacentRepeatedCharactersI {
    public String deDup(String input) {
        // Write your solution here
        if (input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 1;
        int fast = 1;
        while (fast < array.length) {
            if (array[fast] != array[slow - 1]) {
                array[slow] = array[fast];
                slow++;
            }
            fast++;
        }
        return new String(array, 0, slow);
    }
}
