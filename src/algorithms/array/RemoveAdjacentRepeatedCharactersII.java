package algorithms.array;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/80
 * Method: slow and fast pointer,
 *  a a a a b b b c
 *  s
 *  f
 *
 *  b a b a b b b c
 *  s
 *  f
 *  slow: letters to the left are the result to return
 *  fast: letters to the left are processed letters.
 *  case 1: if a[f] != a[s - 2]
 *  a[s] = a[f]
 *  s++, f++
 *  case 2: else
 *  f++
 */
public class RemoveAdjacentRepeatedCharactersII {
    public String deDup(String input) {
        // Write your solution here
        if (input == null || input.length() <= 2) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 2;
        int fast = 2;
        while (fast < array.length) {
            if (array[fast] != array[slow - 2]) {
                array[slow++] = array[fast++];
            } else {
                fast++;
            }
        }
        return new String(array, 0, slow);
    }
}
