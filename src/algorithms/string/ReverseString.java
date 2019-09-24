package algorithms.string;

public class ReverseString {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/396
 * Method: iterative
 */
    public String reverse(String input) {
        // Write your solution here
        // sanity check
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 0;
        int fast = array.length - 1;
        while (slow < fast) {
            swap(array, slow, fast);
            slow++;
            fast--;
        }
        return new String(array);
    }
    private void swap(char[] array, int slow, int fast) {
        char temp = array[slow];
        array[slow] = array[fast];
        array[fast] = temp;
    }
}
