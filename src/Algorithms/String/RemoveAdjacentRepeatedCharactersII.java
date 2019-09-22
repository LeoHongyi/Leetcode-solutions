package Algorithms.String;

/**
 * Remove adjacent, repeated characters in a given string, leaving only two characters for each group of such characters. The characters in the string are sorted in ascending order.
 * Assumptions
 * Try to do it in place.
 * Examples
 * “aaaabbbc” is transferred to “aabbc”
 * Corner Cases
 * If the given string is null, we do not need to do anything.
 Method: slow and fast pointer,
 a a a a b b b c
 s
 f

 b a b a b b b c
 s
 f
 slow: letters to the left are the result to return
 fast: letters to the left are processed letters.
 case 1: if a[f] == a[s - 2] && a[f] == a[s - 1],
 f++
 case 2: else
 a[s] = a[f]
 s++, f++
 **/
public class RemoveAdjacentRepeatedCharactersII {
    public String deDuplicate(String input) {
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
